package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estaciones")
public class EstacionController {

    private final EstacionRepository estacionRepository;

    public EstacionController(EstacionRepository estacionRepository) {
        this.estacionRepository = estacionRepository;
    }

    @PostMapping
    public Estacion crearEstacion(@RequestBody Estacion estacion) {
        Estacion nuevaEstacion = new Estacion();
        nuevaEstacion.setCapacidad(estacion.getCapacidad());
        nuevaEstacion.setTipo(estacion.getTipo());
        return estacionRepository.save(nuevaEstacion);
    }
    @DeleteMapping("/{id}")
    public void eliminarEstacion(@PathVariable Long id) {
        estacionRepository.deleteById(id);
    }
}
