package br.saoroque.repository.estoquecabo;

import java.util.List;

import br.saoroque.model.EstoqueCabo;
import br.saoroque.repository.filter.EstoqueCaboFilter;

public interface EstoqueCaboRepositoryQuery {
    public List<EstoqueCabo> pesquisar( EstoqueCaboFilter estoqueCaboFilter);

}
