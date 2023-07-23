package com.henry.davis.jobs.to.workers.job;

import com.henry.davis.jobs.to.workers.SharedController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "jobs")
@Slf4j
public class JobController implements SharedController<Job, Long> {

    private final JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @Override
    public ResponseEntity<Job> findById(Long id) {
        return ResponseEntity.ok(jobService.get(id));
    }

    @Override
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.getAll());
    }
}
