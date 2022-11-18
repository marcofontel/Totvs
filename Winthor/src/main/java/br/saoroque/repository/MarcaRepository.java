package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
    List<Marca> findAll();

}
