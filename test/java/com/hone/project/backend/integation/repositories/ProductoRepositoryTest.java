package com.hone.project.backend.integation.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.hone.project.backend.integration.model.CategoriaDTO;
import com.hone.project.backend.integration.model.ProductoDTO;
import com.hone.project.backend.integration.repositories.ProductoRepository;

@RunWith(SpringRunner.class)  //Puente entre JUnit y Spring Boot
@DataJpaTest            // Necesario par probar la capa de integración

public class ProductoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductoRepository productoRepository;// Esta es la clase que vamos a testear
	
	// Los métodos de Test deben ser totalmente independientes entre ellos...
		@Test
		public void whenFindByNombre() {
			//given
			ProductoDTO producto = new ProductoDTO();
			producto.setCodigo(1000L);
			
			// I have to set up everything because the database do not accept null
			
			producto.setDescripcion("some description");
			producto.setDescatalogado(false);
			producto.setFechaAlta(new Date());
			producto.setPrecio(40);
			producto.setCategoria(CategoriaDTO.CAFE);
			
			//producto.setId(10000L);
			producto.setNombre("Producto de Test");
			entityManager.persist(producto);			// Lo persisto "manualmente"
			entityManager.flush();  					// Hace efectiva la persistencia
            
			//when
			ProductoDTO productoEncontrado = productoRepository.getOne(1000L);
			
			//then
			assertThat(productoEncontrado.getNombre()).isEqualTo(producto.getNombre());
			
		}
		@Test
		public void whenFindAll() {
			
			//when
			List<ProductoDTO> productos = productoRepository.findAll();
			
			//then
			assertThat(productos.size()).isEqualTo(41);	
		}
		
		
		
		
		
			

}
