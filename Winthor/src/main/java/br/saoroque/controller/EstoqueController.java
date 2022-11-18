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
import br.saoroque.model.Estoque;
import br.saoroque.model.EstoquePK;
import br.saoroque.repository.EstoqueRepository;


@RestController
@RequestMapping("/api/v1")
public class EstoqueController {
	
    @Autowired
	private EstoqueRepository estoqueRepository;
    
    @GetMapping("/estoques")
 	public List<Estoque> getAllEstoques() {
	    List<Estoque> e = estoqueRepository.findAll();
		return e;
		
	}

	@GetMapping("/estoques/{codprod}/{codfilial}")
	public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long codprod, @PathVariable Long codfilial)
			throws ResourceNotFoundException {
		EstoquePK id = new EstoquePK( codprod, codfilial);
	    Estoque estoque = estoqueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + id));		    
		return ResponseEntity.ok().body(estoque);
	}
	 
	
	@PostMapping("/estoques")
	public Estoque createTabPedido(@Valid @RequestBody Estoque estoque) {
		return estoqueRepository.save(estoque);
	}

	@PutMapping("/estoque/{codprod}/{codfilial}")
	   public ResponseEntity <Estoque> updateEstoque(@PathVariable Long codprod, @PathVariable Long codfilial,			  
			@Valid @RequestBody Estoque estoqueDetails) throws ResourceNotFoundException{
	    EstoquePK id = new EstoquePK( codprod, codfilial);
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + id));
	        
	        
			final Estoque updateEstoque = estoqueRepository.save(estoque);
		  	return ResponseEntity.ok(updateEstoque);
		   
	   }
	
	 @DeleteMapping("/estoques/{codprod}/{codfilial}")
	    public Map < String, Boolean > deleteEstoque(@PathVariable Long codprod, @PathVariable Long codfilial)
	    throws ResourceNotFoundException {
	        EstoquePK id = new EstoquePK( codprod, codfilial);
	        Estoque estoque = estoqueRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + id));

	        estoqueRepository.delete(estoque);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
