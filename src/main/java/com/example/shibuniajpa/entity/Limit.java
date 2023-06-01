package com.example.shibuniajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "CB_LIMIT")
@Data
public class Limit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String data;

    @Column(insertable=false, updatable=false)
    private Long cbEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cbEntityId", nullable = false)
    @JsonIgnore
    private CbEntity cbEntity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Limit limit = (Limit) o;
        return id.equals(limit.id) && data.equals(limit.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public String toString() {
        return "Limit{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
