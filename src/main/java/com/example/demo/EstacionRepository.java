package com.example.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface EstacionRepository extends Neo4jRepository<Estacion, Long> {
    // Obtener transformadores conectados a una estación
    @Query("MATCH (e:Estacion)-[:Conecta]->(c:Estacion {nombre: $nombre}) RETURN e")
    List<Estacion> getEstacionesConectadas(String nombre);
    // Obtener las estaciones a las que pertenece un transformador
    @Query("MATCH (t:Transformador)-[:Pertenece_a]->(e:Estacion) WHERE id(t) = $transformadorId RETURN e")
    Estacion getEstacionPertenece(Long transformadorId);
}
