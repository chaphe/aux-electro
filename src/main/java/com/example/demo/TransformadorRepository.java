package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TransformadorRepository extends Neo4jRepository<Transformador, Long> {
}
