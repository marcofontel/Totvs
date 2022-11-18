package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Transportadora;
import br.saoroque.repository.filter.TransportadoraFilter;
import br.saoroque.repository.transportadora.TransportadoraRepositoryQuery;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>, TransportadoraRepositoryQuery{

    List<Transportadora> pesquisar(TransportadoraFilter transportadoraFilter);   

}
