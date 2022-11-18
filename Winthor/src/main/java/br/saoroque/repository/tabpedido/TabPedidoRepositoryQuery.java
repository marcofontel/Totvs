package br.saoroque.repository.tabpedido;

import java.util.List;

import br.saoroque.model.TabPedido;
import br.saoroque.repository.filter.TabPedidosFilter;

public interface TabPedidoRepositoryQuery {
	
	public List<TabPedido> filtrar( TabPedidosFilter tabPedidosFilter);

}
