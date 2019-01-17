package com.hone.project.backend.business.services;

import java.util.List;

import com.hone.project.backend.business.model.Cliente;


public interface ClienteServices {

	public Cliente getById(Long id);
	
	public List<Cliente> getAll();
	
	public Cliente create(Cliente cliente);
	
	
}
