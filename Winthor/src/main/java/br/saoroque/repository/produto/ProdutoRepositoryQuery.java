package br.saoroque.repository.produto;

import java.util.List;

import br.saoroque.model.Produto;
import br.saoroque.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
	
	public List<Produto> pesquisar( ProdutoFilter produtoFilter);

}
