package com.example.demo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "estrato")
    private Integer estrato;

    @Property(name = "tipo")
    private String tipo;

    @Property(name = "direccion")
    private String direccion;

    @Property(name = "nombre")
    private String nombre;

    // Getters y setters
}
