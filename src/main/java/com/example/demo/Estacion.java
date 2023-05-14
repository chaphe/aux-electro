package com.example.demo;

import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node
public class Estacion {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "capacidad")
    private Integer capacidad;

    @Property(name = "tipo")
    private String tipo;

    @Relationship(type = "Conecta", direction = Relationship.Direction.OUTGOING)
    private Set<Estacion> estacionesConectadas = new HashSet<>();

    //@Relationship(type = "Administra", direction = Relationship.Direction.OUTGOING)
    //private Set<Transformador> transformadoresAdministra = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Estacion> getEstacionesConectadas() {
        return estacionesConectadas;
    }

    public void conectar(Estacion otraEstacion) {
        estacionesConectadas.add(otraEstacion);
    }

    public void desconectar(Estacion estacion) {
        estacionesConectadas.remove(estacion);
        estacion.getEstacionesConectadas().remove(this);
    }
}

