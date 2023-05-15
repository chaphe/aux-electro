package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable("id") Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable("id") Long id, @RequestBody Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setDireccion(clienteActualizado.getDireccion());
            clienteExistente.setTipo(clienteActualizado.getTipo());
            clienteExistente.setEstrato(clienteActualizado.getEstrato());
            return clienteRepository.save(clienteExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
    }
}
