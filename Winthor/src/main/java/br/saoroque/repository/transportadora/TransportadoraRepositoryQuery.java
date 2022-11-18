package br.saoroque.repository.transportadora;

import java.util.List;

import br.saoroque.model.Transportadora;
import br.saoroque.repository.filter.TransportadoraFilter;

public interface TransportadoraRepositoryQuery {
    public List<Transportadora> pesquisar( TransportadoraFilter transportadoraFilter);

}
