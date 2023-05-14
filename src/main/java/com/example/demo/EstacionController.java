package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/estaciones")
public class EstacionController {

    private final EstacionRepository estacionRepository;
    private final TransformadorRepository transformadorRepository;

    public EstacionController(EstacionRepository estacionRepository, TransformadorRepository transformadorRepository) {
        this.estacionRepository = estacionRepository;
        this.transformadorRepository = transformadorRepository;
    }

    @GetMapping
    public Iterable<Estacion> obtenerTodasLasEstaciones() {
        return estacionRepository.findAll();
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

    @PostMapping("/{idEstacionOrigen}/conectar/{idEstacionDestino}")
    public void conectarEstaciones(@PathVariable Long idEstacionOrigen, @PathVariable Long idEstacionDestino) {
        Optional<Estacion> estacionOrigen = estacionRepository.findById(idEstacionOrigen);
        Optional<Estacion> estacionDestino = estacionRepository.findById(idEstacionDestino);

        if (estacionOrigen.isPresent() && estacionDestino.isPresent()) {
            Estacion origen = estacionOrigen.get();
            Estacion destino = estacionDestino.get();

            if (!origen.getEstacionesConectadas().contains(destino)) {
                origen.conectar(destino);
                estacionRepository.save(origen);
            }
        }
    }

    @PostMapping("/{idEstacionOrigen}/desconectar/{idEstacionDestino}")
    public void desconectarEstaciones(@PathVariable Long idEstacionOrigen, @PathVariable Long idEstacionDestino) {
        Optional<Estacion> estacionOrigen = estacionRepository.findById(idEstacionOrigen);
        Optional<Estacion> estacionDestino = estacionRepository.findById(idEstacionDestino);

        if (estacionOrigen.isPresent() && estacionDestino.isPresent()) {
            Estacion origen = estacionOrigen.get();
            Estacion destino = estacionDestino.get();

            if (origen.getEstacionesConectadas().contains(destino)) {
                origen.desconectar(destino);
                estacionRepository.save(origen);
            }
        }
    }
}
