package br.saoroque.repository.funcionario;

import java.util.List;

import br.saoroque.model.Funcionario;
import br.saoroque.repository.filter.FuncionarioFilter;

public interface FuncionarioRepositoryQuery {
    public List<Funcionario> pesquisar( FuncionarioFilter funcionarioFilter);

}
