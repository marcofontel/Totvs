package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.EstoqueCabo;
import br.saoroque.repository.estoquecabo.EstoqueCaboRepositoryQuery;
import br.saoroque.repository.filter.EstoqueCaboFilter;

public interface EstoqueCaboRepository extends JpaRepository<EstoqueCabo, Long>, EstoqueCaboRepositoryQuery{

    List<EstoqueCabo> pesquisar(EstoqueCaboFilter estoqueCaboFilter);   

}
