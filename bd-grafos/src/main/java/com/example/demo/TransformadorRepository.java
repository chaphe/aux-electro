package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface TransformadorRepository extends Neo4jRepository<Transformador, Long> {
    List<Transformador> findByCapacidad(Integer capacidad);
}
