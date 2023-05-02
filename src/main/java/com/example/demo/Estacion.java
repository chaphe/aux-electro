package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@SpringBootApplication
@Node
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "capacidad")
    private Integer capacidad;

    @Property(name = "tipo")
    private String tipo;

    // Getters y setters
}
