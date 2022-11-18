package br.saoroque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.model.Marca;
import br.saoroque.repository.MarcaRepository;
import br.saoroque.repository.filter.NotaFiscalSaidaFilter;


@RestController
@RequestMapping("/api/v1")
public class MarcaController {

    @Autowired
    private MarcaRepository repository;    

    @GetMapping("/marca")
    public List<Marca> getProduto(NotaFiscalSaidaFilter notaFiscalSaidaFilter) {      
        return repository.findAll();
    }
}
