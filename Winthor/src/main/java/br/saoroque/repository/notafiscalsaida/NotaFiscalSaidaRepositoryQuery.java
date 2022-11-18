package br.saoroque.repository.notafiscalsaida;

import java.util.List;

import br.saoroque.model.NotaFiscalSaida;
import br.saoroque.repository.filter.NotaFiscalSaidaFilter;

public interface NotaFiscalSaidaRepositoryQuery {
	
	public List<NotaFiscalSaida> pesquisar( NotaFiscalSaidaFilter notaFiscalSaidaFilter);

}
