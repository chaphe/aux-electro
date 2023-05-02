package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EstacionRepository extends Neo4jRepository<Estacion, Long> {
}
