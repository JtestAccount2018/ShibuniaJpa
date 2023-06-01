package com.example.shibuniajpa.controller;

import com.example.shibuniajpa.entity.CbEntity;
import com.example.shibuniajpa.repository.CbEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CbEntityController {

    private final CbEntityRepository repository;

    @PostMapping("cb")
    public void save(@RequestBody CbEntity entity){
        entity.getLimits().forEach(l -> l.setCbEntity(entity));
        repository.save(entity);
    }

    @GetMapping("cb")
    public List<CbEntity> getAll(){
        return repository.findAll();
    }

}
