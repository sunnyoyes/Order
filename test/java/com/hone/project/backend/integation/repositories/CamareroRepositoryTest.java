package com.hone.project.backend.integation.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.hone.project.backend.integration.model.CamareroDTO;
import com.hone.project.backend.integration.repositories.CamareroRepository;


@RunWith(SpringRunner.class)  	//Puente entre JUnit y Spring Boot
@DataJpaTest					// Necesario par probar la capa de integración
public class CamareroRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CamareroRepository camareroRepository; // Esta es la clase que vamos a testear
	
	
	// Los métodos de Test deben ser totalmente independientes entre ellos...
	@Test
	public void whenFindByNombre() {
		
		//given
		CamareroDTO camarero = new CamareroDTO();
		camarero.setId(10000L);
		camarero.setNombre("Camarero de Test");
		testEntityManager.persist(camarero);			// Lo persisto "manualmente"
		testEntityManager.flush();  					// Hace efectiva la persistencia
		
		//when
		CamareroDTO camareroEncontrado = camareroRepository.findByNombre("Camarero de Test");
		
		//then
		assertThat(camareroEncontrado.getNombre()).isEqualTo(camarero.getNombre());
		
	}
	
	@Test
	public void whenFindAll() {
		
		//when
		List<CamareroDTO> camareros = camareroRepository.findAll();
		
		//then
		assertThat(camareros.size()).isEqualTo(3);	
	}
	
	@Test
	public void whenCreate() {
		
		//TODO
		
		//when
		CamareroDTO nuevoCamarero = new CamareroDTO(1000L, "NUEVO");
		
		// Cómo comprobar que la siguiente linea funciona?
		camareroRepository.save(nuevoCamarero);
		
		// INNECESARIO?
		
		// Obtengo el entityManager "normal" para poder consultar cualquier tipo
		// de cosa que el de Test no incorpora...
		
//		EntityManager entityManager = testEntityManager.getEntityManager();
		
//		String strJPQL = "select c from CamareroDTO c";
//		Query query = entityManager.createQuery(strJPQL);
		
//		List<CamareroDTO> camareros = query.getResultList();
		
				
		camareroRepository.save(new CamareroDTO());
		
	}
	
	
	
	
	
	
	
}
