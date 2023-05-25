package com.example.demo;
import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface ClienteRepository extends Neo4jRepository<Cliente, Long> {
    List<Cliente> findByEstrato(int estrato);

}
