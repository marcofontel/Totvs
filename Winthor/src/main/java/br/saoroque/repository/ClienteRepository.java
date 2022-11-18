package br.saoroque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
