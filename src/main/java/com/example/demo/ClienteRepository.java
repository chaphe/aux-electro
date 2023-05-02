package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ClienteRepository extends Neo4jRepository<Cliente, Long> {
}
