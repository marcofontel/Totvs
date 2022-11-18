package br.saoroque.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.exception.ResourceNotFoundException;
import br.saoroque.model.Entrega;
import br.saoroque.repository.AjelEntregaRepository;
import br.saoroque.repository.filter.AjelEntregaFilter;
import br.saoroque.services.AjelEntregaService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class EntregaController {
	
    @Autowired
	private AjelEntregaRepository ajelEntregaRepository;
    
    @Autowired
    private AjelEntregaService ajelEntregaService;

//	@GetMapping("/estoquecabos")
    //public List<Entrega> getAllEstoqueCabos() {
	//	return estoqueCaboRepository.findAll();
		
	//}

	@GetMapping("/ajelentrega")
	public List<Entrega> getAjelEntregas(AjelEntregaFilter ajelEntregaFilter) {      
	        return ajelEntregaRepository.pesquisar(ajelEntregaFilter);
	    }

	@GetMapping("/ajelentrega/codentrega/{codentrega}")
	public ResponseEntity<Entrega> getEntregaById(@PathVariable Long codentrega)
			throws ResourceNotFoundException {
		Entrega ajelEntrega = ajelEntregaRepository.findById(codentrega)
				.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + codentrega));
		return ResponseEntity.ok().body(ajelEntrega);
	}
	
	@PostMapping("/ajelentrega/numnota")
    public ResponseEntity<List<Entrega>> getEntregaByNumnota(@RequestBody AjelEntregaFilter filter)
            throws ResourceNotFoundException {
	    List<Entrega> ajelEntrega = null;
	    ajelEntrega = ajelEntregaRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(ajelEntrega);
    }
	
	@PostMapping("/ajelentrega/dtentrega")
    public ResponseEntity<List<Entrega>> getEntregaByDtEntrega(@RequestBody AjelEntregaFilter filter)
            throws ResourceNotFoundException {
        List<Entrega> ajelEntrega = null;
        ajelEntrega = ajelEntregaRepository.pesquisar(filter);
                //.orElseThrow(() -> new ResourceNotFoundException("Produto not found for this id :: " + numnota));
        return ResponseEntity.ok().body(ajelEntrega);
    }

	
	@PostMapping("/ajelentrega")
	public Entrega createAjelEntrega(@Valid @RequestBody Entrega ajelEntrega) {
	    ajelEntrega.setDtinclusao(new Date());
	    return ajelEntregaRepository.save(ajelEntrega);
	}
	
	@PostMapping("/ajelentrega/pesquisarNotaWinthor") 
    public ResponseEntity<List<Entrega>> getInformacaoPedidoById(@RequestBody AjelEntregaFilter filter)
            throws ResourceNotFoundException {
        List<Entrega> pedidoWinthor = null;        
        pedidoWinthor = ajelEntregaService.findByNumnota(filter); 
        
        return ResponseEntity.ok().body(pedidoWinthor);
    }

	@PutMapping("/ajelentrega/alterarSeparacao/{codentrega}")
	   public ResponseEntity <Entrega> updateAjelEntrega(@PathVariable(value = "codentrega") Long codentrega,			  
			@Valid @RequestBody Entrega ajelEntregaDetails) throws ResourceNotFoundException{
	        Entrega ajelEntrega = ajelEntregaRepository.findById(codentrega).orElseThrow(() -> new ResourceNotFoundException("Erro na Entrega: "+ codentrega));
	        //ajelEntrega.setCodcidade(ajelEntregaDetails.getCodcidade());
	        ajelEntrega.setObsdoentregador(ajelEntregaDetails.getObsdoentregador());
	        ajelEntrega.setLocal(ajelEntregaDetails.getLocal());
	        ajelEntrega.setCodfornecfrete(ajelEntregaDetails.getCodfornecfrete());
	        ajelEntrega.setCodfuncconf(ajelEntregaDetails.getCodfuncconf());
	        ajelEntrega.setCodmotorista(ajelEntregaDetails.getCodmotorista());
	        //ajelEntrega.setDtentrega(ajelEntregaDetails.getDtentrega());
	        //ajelEntrega.setEndercob(ajelEntregaDetails.getEndercob());
	        //ajelEntrega.setNomecidade(ajelEntregaDetails.getNomecidade());
	        ajelEntrega.setFornecedor(ajelEntregaDetails.getFornecedor());
	        ajelEntrega.setNomemotorista(ajelEntregaDetails.getNomemotorista());
	        ajelEntrega.setNomeconf(ajelEntregaDetails.getNomeconf());
	        ajelEntrega.setLocal(ajelEntregaDetails.getLocal());
	        
			final Entrega updateAjelEntrega = ajelEntregaRepository.save(ajelEntrega);
		  	return ResponseEntity.ok(updateAjelEntrega);
		   
	   }
	
	@PutMapping("/ajelentrega/dataExlusao/{codentrega}")
    public ResponseEntity<Entrega> dataExclusao(@PathVariable(value = "codentrega") Long codentrega) throws ResourceNotFoundException {
        Entrega ajelEntrega = ajelEntregaRepository.findById(codentrega)
                .orElseThrow(() -> new ResourceNotFoundException("Erro na entrega :: " + codentrega));
        
        ajelEntrega.setDtexclusao(new Date());
          

        final Entrega updateAjelEntrega = ajelEntregaRepository.save(ajelEntrega);
        return ResponseEntity.ok(updateAjelEntrega);
        }
	
	 @DeleteMapping("/ajelentrega/{codentrega}")
	    public Map < String, Boolean > deleteEstoqueCabo(@PathVariable(value = "codentrega") Long codentrega)
	    throws ResourceNotFoundException {
	        Entrega ajelEntrega = ajelEntregaRepository.findById(codentrega)
	            .orElseThrow(() -> new ResourceNotFoundException("Erro na entrega: " + codentrega));

	        ajelEntregaRepository.delete(ajelEntrega);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }


}
