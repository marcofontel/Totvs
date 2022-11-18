package br.saoroque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
