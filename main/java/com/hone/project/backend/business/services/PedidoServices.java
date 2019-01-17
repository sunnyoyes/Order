package com.hone.project.backend.business.services;

import java.util.List;

import com.hone.project.backend.business.model.LineaPedido;
import com.hone.project.backend.business.model.Pedido;

public interface PedidoServices {

	public Pedido getById(Long id) throws Exception;
	
	public List<Pedido> getAll() throws Exception;
	
	public Pedido create(Pedido pedido) throws Exception;
	
	
	// Obtención de lineas de pedido
	
	public List<LineaPedido> getLineasPedido();
	
	public List<LineaPedido> getLineasPedidoByCodigoProducto(long codigoProducto);
	
}
