package br.saoroque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.exception.ResourceNotFoundException;
import br.saoroque.model.EstoqueCabo;
import br.saoroque.model.Transportadora;
import br.saoroque.repository.TransportadoraRepository;
import br.saoroque.repository.filter.TransportadoraFilter;


@RestController
@RequestMapping("/api/v1")
public class TransportadoraController {

    @Autowired
    private TransportadoraRepository repository;    

    @GetMapping("/transportadora/{revenda}")
    public List<Transportadora> getTransportadora(TransportadoraFilter transportadoraFilter) {      
        return repository.pesquisar(transportadoraFilter);
    }
}
