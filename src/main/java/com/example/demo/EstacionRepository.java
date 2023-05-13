package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface EstacionRepository extends Neo4jRepository<Estacion, Long> {
    @Query("MATCH (e:Estacion)-[:Conecta]->(c:Estacion {nombre: $nombre}) RETURN e")
    List<Estacion> getEstacionesConectadas(String nombre);
}
