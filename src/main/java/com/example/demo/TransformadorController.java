package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public Transformador getTransformadorById(@PathVariable Long id) {
        return transformadorRepository.findById(id).orElse(null);
    }

    @GetMapping("/")
    public List<Transformador> getAllTransformadores() {
        return transformadorRepository.findAll();
    }

    @PostMapping("/")
    public Transformador createTransformador(@RequestBody Transformador transformador) {
        return transformadorRepository.save(transformador);
    }

    @PutMapping("/{id}")
    public Transformador updateTransformador(@PathVariable Long id, @RequestBody Transformador transformador) {
        Transformador existingTransformador = transformadorRepository.findById(id).orElse(null);
        if (existingTransformador == null) {
            return null;
        }
        existingTransformador.setCapacidad(transformador.getCapacidad());
        existingTransformador.setEstado(transformador.getEstado());
        existingTransformador.setTipo(transformador.getTipo());
        return transformadorRepository.save(existingTransformador);
    }

    @DeleteMapping("/{id}")
    public void deleteTransformador(@PathVariable Long id) {
        transformadorRepository.deleteById(id);
    }
}
