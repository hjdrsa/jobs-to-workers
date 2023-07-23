package com.henry.davis.jobs.to.workers.worker;

import com.henry.davis.jobs.to.workers.SharedController;
import com.henry.davis.jobs.to.workers.job.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "workers")
@Slf4j
public class WorkerController implements SharedController<Worker, Long> {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }

    @Override
    public ResponseEntity<Worker> findById(Long id) {
        return ResponseEntity.ok(workerService.get(id));
    }

    @Override
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(workerService.getAll());
    }
}
