package com.supply.supply.cliente.controller;


import com.supply.supply.cliente.model.Cliente;
import com.supply.supply.cliente.dto.ClienteDto;
import com.supply.supply.cliente.service.ClienteService;
import com.supply.supply.cliente.service.ClienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController implements ClienteService {

    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Long id) {
        Optional<ClienteDto> cliente = clienteService.findClienteById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDto>> getClientes() {
        List<ClienteDto> clientes = clienteService.findAllClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }


    @PutMapping("/{id}/aprobar")
    public ResponseEntity<Cliente> aprobarCliente(@PathVariable Long id) {
        try {
            Cliente clienteAprobado = clienteService.aprobarCliente(id);
            return ResponseEntity.ok(clienteAprobado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}