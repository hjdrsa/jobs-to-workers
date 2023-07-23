package com.henry.davis.jobs.to.workers.matcher;

import com.henry.davis.jobs.to.workers.SharedController;
import com.henry.davis.jobs.to.workers.geo.DistanceCalculator;
import com.henry.davis.jobs.to.workers.job.Job;
import com.henry.davis.jobs.to.workers.job.JobService;
import com.henry.davis.jobs.to.workers.worker.Worker;
import com.henry.davis.jobs.to.workers.worker.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "matcher")
@Slf4j
public class JobMatcherController implements SharedController<List<Job>, Long> {

    private final WorkerService workerService;

    private final JobService jobService;

    public JobMatcherController(WorkerService workerService, JobService jobService) {
        this.workerService = workerService;
        this.jobService = jobService;
    }

    @Override
    public ResponseEntity<List<Job>> findById(Long id) {

        Worker worker = workerService.get(id);
        if (worker == null){
          return ResponseEntity.notFound().build();
        }

        if(worker.isActive() == false){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        List<Job> jobs = jobService.getAll();

        return ResponseEntity.ok(filterJobs(jobs, worker));
    }

    private List<Job> filterJobs(List<Job> jobs, Worker worker) {

        return jobs.stream()
                .filter(job -> worker.getCertificates().containsAll(job.getCertificates()))
                .filter(job -> !job.getDriverLicenseRequired() || worker.isHasDriversLicense())
                .filter(job -> DistanceCalculator.distance(
                                job.getLocation().getLatitude(), job.getLocation().getLongitude(),
                                worker.getJobSearchAddress().getLatitude(), worker.getJobSearchAddress().getLongitude()
                        ).intValue() <= worker.getJobSearchAddress().getMaxJobDistance())
                .sorted(Comparator.comparing(job -> new BigDecimal(job.getBillRate().substring(1)), Comparator.reverseOrder()))
                .sorted(Comparator.comparing(job -> DistanceCalculator.distance(
                        job.getLocation().getLatitude(), job.getLocation().getLongitude(),
                        worker.getJobSearchAddress().getLatitude(), worker.getJobSearchAddress().getLongitude()
                ).intValue()))
                .sorted(Comparator.comparing(job -> {
                    Set<String> jobCertificates = new HashSet<>(job.getCertificates());
                    jobCertificates.retainAll(worker.getCertificates());
                    return -jobCertificates.size();
                }))
                .limit(3)
                .collect(Collectors.toList());
    }
}
