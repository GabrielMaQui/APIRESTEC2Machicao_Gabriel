package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoDetalle;

import java.util.List;

public interface IPedidoDetalleRepository extends JpaRepository<PedidoDetalle, Integer> {
    List<PedidoDetalle> findByPedidoCabeceraCodPedCab(Integer codPedCab);
}