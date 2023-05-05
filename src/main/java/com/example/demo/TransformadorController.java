package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<Transformador> obtenerTransformadores() {
        return transformadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transformador> obtenerTransformadorPorId(@PathVariable Long id) {
        return transformadorRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarTransformadorPorId(@PathVariable Long id) {
        transformadorRepository.deleteById(id);
    }
}
