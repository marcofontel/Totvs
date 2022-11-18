package br.saoroque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.Funcionario;
import br.saoroque.repository.filter.FuncionarioFilter;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{  
    
    List<Funcionario> pesquisar(FuncionarioFilter funcionarioFilter);   

}
