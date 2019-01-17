package com.hone.project.backend.presentation.services;

import java.util.List;


import com.hone.project.backend.presentation.model.LineaPedidoVO;
import com.hone.project.backend.presentation.model.PedidoVO;



public interface PedidoPresentationServices {

	public PedidoVO getById(Long id) throws Exception;
	
	public List<PedidoVO> getAll() throws Exception;
	
	public PedidoVO create(PedidoVO pedidoVO) throws Exception;
	
	public List<LineaPedidoVO> getAllLineas() throws Exception;
	
	public List<LineaPedidoVO> getLineasPedidoByCodigoProducto(long codigoProducto) throws Exception;
	
}
