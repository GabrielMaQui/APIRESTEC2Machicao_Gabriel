package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoDetalle;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IPedidoDetalleRepository;

import java.util.List;

@Service
public class PedidoDetalleService {

    @Autowired
    private IPedidoDetalleRepository pedidoDetalleRepository;

    public List<PedidoDetalle> getAllPedidoDetalles() {
        return pedidoDetalleRepository.findAll();
    }

    public PedidoDetalle getPedidoDetalleById(Integer id) {
        return pedidoDetalleRepository.findById(id).orElse(null);
    }

    public PedidoDetalle createPedidoDetalle(PedidoDetalle pedidoDetalle) {
        return pedidoDetalleRepository.save(pedidoDetalle);
    }

    public PedidoDetalle updatePedidoDetalle(Integer id, PedidoDetalle pedidoDetalle) {
        PedidoDetalle existingPedidoDetalle = pedidoDetalleRepository.findById(id).orElse(null);
        if (existingPedidoDetalle != null) {
            pedidoDetalle.setSecDet(id);
            return pedidoDetalleRepository.save(pedidoDetalle);
        }
        return null;
    }

    public void deletePedidoDetalle(Integer id) {
        pedidoDetalleRepository.deleteById(id);
    }
}