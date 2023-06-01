package com.example.shibuniajpa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CbEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String data;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "cbEntity", fetch = FetchType.EAGER)
    List<Limit> limits;

}
