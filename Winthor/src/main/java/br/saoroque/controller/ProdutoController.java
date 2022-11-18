package br.saoroque.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.exception.ResourceNotFoundException;
import br.saoroque.model.Produto;
import br.saoroque.repository.ProdutoRepository;
import br.saoroque.repository.filter.ProdutoFilter;


@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
	
    @Autowired
	private ProdutoRepository produtoRepository;    

    
	@GetMapping("/produto")
	public List<Produto> getProduto(ProdutoFilter produtoFilter) {		
        return produtoRepository.pesquisar(produtoFilter);
	}

	@GetMapping("/produto/{codprod}")
	public ResponseEntity<Produto> getProdutoById(@PathVariable Long codprod)
			throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(codprod)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codprod));
		return ResponseEntity.ok().body(produto);
	}
		
	@PostMapping("/produto")
	public Produto createProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/produto/{codprod}")
	   public ResponseEntity <Produto> updateProduto(@PathVariable(value = "codprod") Long codprod,			  
			@Valid @RequestBody Produto estoqueCaboDetails) throws ResourceNotFoundException{
	        Produto produto = produtoRepository.findById(codprod).orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: "+ codprod));
	        produto.setCodprod(estoqueCaboDetails.getCodprod());
	       
	        
			final Produto updateEstoqueCabo = produtoRepository.save(produto);
		  	return ResponseEntity.ok(updateEstoqueCabo);
		   
	   }
	
	 @DeleteMapping("/produto/{codprod}")
	    public Map < String, Boolean > deleteProduto(@PathVariable(value = "codprod") Long codprod)
	    throws ResourceNotFoundException {
	        Produto produto = produtoRepository.findById(codprod)
	            .orElseThrow(() -> new ResourceNotFoundException("vendedor não encontrado com esse Numped :: " + codprod));

	        produtoRepository.delete(produto);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
