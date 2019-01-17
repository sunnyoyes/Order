package com.hone.project.backend.presentation.services;

import java.util.List;

import com.hone.project.backend.common.Pagina;
import com.hone.project.backend.presentation.model.ProductoVO;


public interface ProductoPresentationServices {

	public List<ProductoVO> getAll() throws Exception;
	
	public ProductoVO getById(Long id) throws Exception;
	
	public ProductoVO create(ProductoVO producto) throws Exception;
	
	public Pagina<ProductoVO> getPagina(int numeroPagina, int numeroElementos) throws Exception;
	
}
