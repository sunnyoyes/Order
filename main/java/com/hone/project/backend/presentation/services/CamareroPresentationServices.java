package com.hone.project.backend.presentation.services;

import java.util.List;

import com.hone.project.backend.presentation.model.CamareroVO;

public interface CamareroPresentationServices {

	public CamareroVO getById(Long id) throws Exception;
	
	public List<CamareroVO> getAll() throws Exception;
	
	public CamareroVO create(CamareroVO camarero) throws Exception;
	
}
