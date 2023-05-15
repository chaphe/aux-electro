package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transformadores")
public class TransformadorController {

    private final TransformadorRepository transformadorRepository;
    private final ClienteRepository clienteRepository;

    private final EstacionRepository estacionRepository;

    public TransformadorController(TransformadorRepository transformadorRepository, ClienteRepository clienteRepository, EstacionRepository estacionRepository) {
        this.transformadorRepository = transformadorRepository;
        this.clienteRepository = clienteRepository;
        this.estacionRepository = estacionRepository;
    }

    @GetMapping("/{id}")
    public Transformador getTransformadorById(@PathVariable Long id) {
        return transformadorRepository.findById(id).orElse(null);
    }

    @GetMapping("/capacidad/{capacidad}")
    public List<Transformador> getTransformadoresByCapacidad(@PathVariable Integer capacidad) {
        return transformadorRepository.findByCapacidad(capacidad);
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

    @PostMapping("/{id}/alimentar/{clienteId}")
    public Transformador alimentarCliente(@PathVariable Long id, @PathVariable Long clienteId) {
        Transformador transformador = transformadorRepository.findById(id).orElse(null);
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (transformador != null && cliente != null) {
            transformador.getClientesAlimentados().add(cliente);
            transformadorRepository.save(transformador);
        }
        return transformador;
    }
    @DeleteMapping("/{id}/desalimentar/{clienteId}")
    public Transformador desalimentarCliente(@PathVariable Long id, @PathVariable Long clienteId) {
        Transformador transformador = transformadorRepository.findById(id).orElse(null);
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (transformador != null && cliente != null) {
            transformador.getClientesAlimentados().remove(cliente);
            transformadorRepository.save(transformador);
        }
        return transformador;
    }
    @PostMapping("/{id}/pertenecer_a/{estacionId}")
    public Transformador asignarEstacion(@PathVariable Long id, @PathVariable Long estacionId) {
        Transformador transformador = transformadorRepository.findById(id).orElse(null);
        Estacion estacion = estacionRepository.findById(estacionId).orElse(null);
        if (transformador != null && estacion != null) {
            transformador.setEstacion(estacion);
            transformadorRepository.save(transformador);
        }
        return transformador;
    }
    @DeleteMapping("/{id}/estaciones")
    public Transformador desasignarEstacion(@PathVariable Long id) {
        Transformador transformador = transformadorRepository.findById(id).orElse(null);
        if (transformador != null) {
            transformador.setEstacion(null);
            transformadorRepository.save(transformador);
        }
        return transformador;
    }


}
