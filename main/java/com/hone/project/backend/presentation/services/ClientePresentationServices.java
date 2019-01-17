package com.hone.project.backend.presentation.services;

import java.util.List;

import com.hone.project.backend.presentation.model.ClienteVO;

public interface ClientePresentationServices {

	public List<ClienteVO> getAll();
	
	public ClienteVO getById(Long id);
	
	public ClienteVO create(ClienteVO cliente);
	
}