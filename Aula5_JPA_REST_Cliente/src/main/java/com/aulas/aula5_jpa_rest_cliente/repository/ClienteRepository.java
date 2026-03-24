package com.aulas.aula5_jpa_rest_cliente.repository;

import com.aulas.aula5_jpa_rest_cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public List<Cliente> findByNome(String nome);
    public List<Cliente> findByEmail(String email);
    public List<Cliente> findByNomeStartingWith(String nome);
}
