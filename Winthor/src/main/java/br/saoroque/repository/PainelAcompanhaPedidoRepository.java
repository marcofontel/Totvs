package br.saoroque.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.TabPedido;


public interface PainelAcompanhaPedidoRepository extends JpaRepository<TabPedido, BigDecimal>{	
		
	

}
