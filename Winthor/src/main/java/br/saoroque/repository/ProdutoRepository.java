package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Produto;
import br.saoroque.repository.filter.ProdutoFilter;
import br.saoroque.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery{

    List<Produto> pesquisar( ProdutoFilter produtoFilter);  
}
