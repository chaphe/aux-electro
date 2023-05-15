package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface ClienteRepository extends Neo4jRepository<Cliente, Long> {
    @Query("MATCH (c:Cliente), (t:Transformador) WHERE id(c) = $clienteId AND id(t) = $transformadorId CREATE (c)-[:Conectado]->(t)")
    void conectarClienteConTransformador(Long clienteId, Long transformadorId);

    @Query("MATCH (c:Cliente)-[r:Conectado]->(t:Transformador) WHERE id(c) = $clienteId AND id(t) = $transformadorId DELETE r")
    void desconectarClienteDeTransformador(Long clienteId, Long transformadorId);

}
