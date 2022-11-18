package br.saoroque.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import br.saoroque.model.TabPedido;
import br.saoroque.repository.tabpedido.TabPedidoRepositoryQuery;

public interface TabPedidoRepository extends JpaRepository<TabPedido, BigDecimal>, TabPedidoRepositoryQuery{	
		
	

}
