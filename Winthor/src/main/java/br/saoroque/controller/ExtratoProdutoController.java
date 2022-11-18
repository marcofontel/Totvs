package br.saoroque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.controller.payloads.ExtratoProdutoPayload;
import br.saoroque.exception.ResourceNotFoundException;
import br.saoroque.repository.filter.ExtratoProdutoFilter;
import br.saoroque.services.ExtratoProdutoService;


@RestController
@RequestMapping("/api/v1")
public class ExtratoProdutoController {
	
    @Autowired
    private ExtratoProdutoService extratoProdutoService;

    @PostMapping("/extratoproduto") //
    public ResponseEntity<List<ExtratoProdutoPayload>> getExtratoProduto(@RequestBody ExtratoProdutoFilter filter)
            throws ResourceNotFoundException {
        List<ExtratoProdutoPayload> extratoProduto = null;
        extratoProduto = extratoProdutoService.findByCodprodEFilial(filter);
        
        return ResponseEntity.ok().body(extratoProduto);
    }
		
	


}
