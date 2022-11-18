package br.saoroque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.model.Funcionario;
import br.saoroque.repository.FuncionarioRepository;
import br.saoroque.repository.TransportadoraRepository;
import br.saoroque.repository.filter.FuncionarioFilter;
import br.saoroque.repository.filter.TransportadoraFilter;


@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;    

    @GetMapping("/funcionario/{codsetor}")
    public List<Funcionario> getTransportadora(FuncionarioFilter funcionarioFilter) {      
        return repository.pesquisar(funcionarioFilter);
    }
}
