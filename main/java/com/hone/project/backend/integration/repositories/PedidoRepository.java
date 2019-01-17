package com.hone.project.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hone.project.backend.integration.model.LineaPedidoDTO;
import com.hone.project.backend.integration.model.PedidoDTO;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoDTO, Long>{

	static final String PATH = "com.hone.project.backend.integration.model.";
								
	@Query("select new " + PATH + "LineaPedidoDTO (lp.producto,lp.cantidad,lp.precio) FROM PedidoDTO p JOIN p.lineasPedido lp")
	List<LineaPedidoDTO> getLineasPedido ();
	
	
	@Query("select new " + PATH + "LineaPedidoDTO (lp.producto,lp.cantidad,lp.precio) "
		 + "FROM PedidoDTO p JOIN p.lineasPedido lp "
		 + "WHERE lp.producto.codigo = :codigoProducto"	)
	List<LineaPedidoDTO> getLineasPedidoByProductoId(@Param ("codigoProducto") Long codigoProducto);
	
}
