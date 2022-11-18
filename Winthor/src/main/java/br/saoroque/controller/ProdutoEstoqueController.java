package br.saoroque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.controller.payloads.ProdutoEstoquePayload;
import br.saoroque.exception.ResourceNotFoundException;
import br.saoroque.repository.filter.ProdutoEstoqueFilter;
import br.saoroque.services.ProdutoEstoqueService;


@RestController
@RequestMapping("/api/v1")
public class ProdutoEstoqueController {
	
    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

    @PostMapping("/produtoestoque") //
    public ResponseEntity<List<ProdutoEstoquePayload>> getProdutoEstoque(@RequestBody ProdutoEstoqueFilter filter)
            throws ResourceNotFoundException {
        List<ProdutoEstoquePayload> produtoEstoque = null;
        produtoEstoque = produtoEstoqueService.findByCodprod(filter);
        
        return ResponseEntity.ok().body(produtoEstoque);
    }
		
	


}
