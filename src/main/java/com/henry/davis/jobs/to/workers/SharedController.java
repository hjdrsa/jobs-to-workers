package com.henry.davis.jobs.to.workers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SharedController<T, ID>  {

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable ID id);

    @GetMapping()
    default ResponseEntity<List<T>> findAll(){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
}
