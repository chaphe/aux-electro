package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estaciones")
public class EstacionController {

    @Autowired
    private EstacionRepository estacionRepository;

    @PostMapping
    public Estacion crearEstacion(@RequestBody Estacion estacion) {
        return estacionRepository.save(estacion);
    }
}
