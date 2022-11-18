package br.saoroque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.saoroque.controller.payloads.PainelAcompanhaPedidoPayload;
import br.saoroque.repository.PainelAcompanhaPedidoRepository;
import br.saoroque.services.PainelAcompanhaPedidoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PainelAcompanhaPedidoController {
	@Autowired
	private PainelAcompanhaPedidoRepository painelAcompanhaPedidoRepository;

	@Autowired
	private PainelAcompanhaPedidoService  painelAcompanhaPedidoService;
	

	
	@GetMapping("/painelAcompanhaPedidoPainel")
	public ResponseEntity<List<PainelAcompanhaPedidoPayload>> getAllPainelAcompanhaPedidoPainel() {
		List<PainelAcompanhaPedidoPayload> resultado = painelAcompanhaPedidoService.findAllPainel();
		return ResponseEntity.ok().body(resultado);

	}


}