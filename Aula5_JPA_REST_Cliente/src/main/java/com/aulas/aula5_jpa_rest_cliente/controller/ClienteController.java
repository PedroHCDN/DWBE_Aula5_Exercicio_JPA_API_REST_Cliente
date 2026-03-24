package com.aulas.aula5_jpa_rest_cliente.controller;

import com.aulas.aula5_jpa_rest_cliente.model.Cliente;
import com.aulas.aula5_jpa_rest_cliente.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula5_jpa_rest_cliente/cliente")
public class ClienteController {
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("{id}")
    public Cliente buscarIdCliente(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @GetMapping("/buscarPorNome")
    public List<Cliente> buscarPorNome(@RequestParam String nome) {
        return clienteRepository.findByNome(nome);
    }

    @GetMapping("/buscarPorEmail")
    public List<Cliente> buscarPorEmail(@RequestParam String email) {
        return clienteRepository.findByEmail(email);
    }

    @GetMapping("/buscarNomeInicio")
    public List<Cliente> buscarNomeInicio(@RequestParam String nome){
        return clienteRepository.findByNomeStartingWith(nome);
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    @DeleteMapping("{id}")
    public String removerCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "Cliente excluido com sucesso";
    }

}
