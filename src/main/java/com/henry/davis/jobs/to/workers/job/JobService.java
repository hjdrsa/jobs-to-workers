package com.henry.davis.jobs.to.workers.job;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class JobService {

    private static final AtomicReference<ConcurrentHashMap<Long, Job>> atomicReferenceMap =
            new AtomicReference<>(new ConcurrentHashMap<>());

    private final ObjectMapper objectMapper;

    public JobService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadDataIntoMemory() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://test.swipejobs.com/api/jobs", String.class);
        List<Job> jobs = objectMapper.readValue(response, new TypeReference<List<Job>>(){});

        for (Job job: jobs) {
            atomicReferenceMap.get().put(job.getId(), job);
        }
        log.info("Number of Jobs {}", jobs.size());
    }

    public Job get(Long key) {
        Job job = atomicReferenceMap.get().get(key);
        return job;
    }

    public List<Job> getAll() {
        return atomicReferenceMap.get().values().stream().toList();
    }
}
