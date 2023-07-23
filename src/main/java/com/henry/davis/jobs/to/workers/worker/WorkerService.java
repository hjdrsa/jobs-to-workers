package com.henry.davis.jobs.to.workers.worker;

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
public class WorkerService {

    private static final AtomicReference<ConcurrentHashMap<Long, Worker>> atomicReferenceMap =
            new AtomicReference(new ConcurrentHashMap());

    private final ObjectMapper objectMapper;

    public WorkerService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadDataIntoMemory() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://test.swipejobs.com/api/workers", String.class);
        List<Worker> workers = objectMapper.readValue(response, new TypeReference<List<Worker>>() {
        });

        for (Worker worker : workers) {
            atomicReferenceMap.get().put(worker.getId(), worker);
        }
        log.info("Number of workers {}", workers.size());
    }

    public Worker get(Long key) {
        Worker worker = atomicReferenceMap.get().get(key);
        return worker;
    }

    public List<Worker> getAll() {
        return atomicReferenceMap.get().values().stream().toList();
    }
}
