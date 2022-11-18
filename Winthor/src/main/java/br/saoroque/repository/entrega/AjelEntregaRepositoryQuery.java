package br.saoroque.repository.entrega;

import java.util.List;

import br.saoroque.model.Entrega;
import br.saoroque.repository.filter.AjelEntregaFilter;

public interface AjelEntregaRepositoryQuery {
    public List<Entrega> pesquisar( AjelEntregaFilter ajelEntregarFilter);

}
