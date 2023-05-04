package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transformadores")
public class TransformadorController {

    private final TransformadorRepository transformadorRepository;

    public TransformadorController(TransformadorRepository transformadorRepository) {
        this.transformadorRepository = transformadorRepository;
    }

    @PostMapping
    public Transformador crearTransformador(@RequestBody Transformador transformador) {
        return transformadorRepository.save(transformador);
    }
}
