package com.example.demo;
import org.springframework.data.neo4j.core.schema.*;
import com.example.demo.Estacion;
import com.example.demo.Cliente;

import java.util.Set;

@Node
public class Transformador {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "capacidad")
    private Integer capacidad;

    @Property(name = "estado")
    private String estado;

    @Property(name = "tipo")
    private String tipo;

    @Relationship(type = "Alimenta", direction = Relationship.Direction.OUTGOING)
    private Set<Cliente> clientesAlimentados;
    private Estacion estacion;


    // Getters y setters
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Cliente> getClientesAlimentados() {
        return clientesAlimentados;
    }

    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }

    public void setClientesAlimentados(Set<Cliente> clientesAlimentados) {
        this.clientesAlimentados = clientesAlimentados;
    }
}
