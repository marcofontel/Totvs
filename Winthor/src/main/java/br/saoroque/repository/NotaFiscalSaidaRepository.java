package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.NotaFiscalSaida;
import br.saoroque.repository.filter.NotaFiscalSaidaFilter;
import br.saoroque.repository.notafiscalsaida.NotaFiscalSaidaRepositoryQuery;

public interface NotaFiscalSaidaRepository extends JpaRepository<NotaFiscalSaida, Long>, NotaFiscalSaidaRepositoryQuery{

    List<NotaFiscalSaida> pesquisar( NotaFiscalSaidaFilter notaFiscalSaidaFilter);  
}
