package com.supply.supply.cliente.service;

import com.supply.supply.cliente.model.Cliente;
import com.supply.supply.cliente.dto.ClienteDto;
import com.supply.supply.cliente.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl {

    private final ClienteRepository repository;
    private final PasswordEncoder passwordEncoder;

    public ClienteServiceImpl(ClienteRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Cliente saveCliente(Cliente cliente) {
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        return repository.save(cliente);
    }

    public Optional<ClienteDto> findClienteById(Long id) {
        return repository.findById(id)
                .map(this::convertToDto);
    }


    public List<ClienteDto> findAllClientes() {
        List<Cliente> clientes = repository.findAll();
        return clientes.stream()
                .map(this::convertToDto) // Mapea cada Cliente a ClienteDto
                .collect(Collectors.toList()); // Colecta los DTOs en una lista
    }


    public Cliente aprobarCliente(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setIsAprobado(true);
        return repository.save(cliente);
    }

    public ClienteDto convertToDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setTelefono(cliente.getTelefono());
        return clienteDto;
    }

}