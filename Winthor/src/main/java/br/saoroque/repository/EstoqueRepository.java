package br.saoroque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Estoque;
import br.saoroque.model.EstoquePK;

public interface EstoqueRepository extends JpaRepository<Estoque, EstoquePK>{   

}
