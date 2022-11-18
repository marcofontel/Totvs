package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Entrega;
import br.saoroque.repository.entrega.AjelEntregaRepositoryQuery;
import br.saoroque.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepository extends JpaRepository<Entrega, Long>, AjelEntregaRepositoryQuery{

    List<Entrega> pesquisar(AjelEntregaFilter ajelEntregaFilter);   
    List<Entrega> findByNumnota(Long numnota);       

}
