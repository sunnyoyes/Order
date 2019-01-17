package com.hone.project.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hone.project.backend.integration.model.ClienteDTO;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteDTO, Long>{

}
