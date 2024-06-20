package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoCabecera;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoDetalle;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IPedidoCabeceraRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IPedidoDetalleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private IPedidoCabeceraRepository pedidoCabeceraRepository;

    @Autowired
    private IPedidoDetalleRepository pedidoDetalleRepository;

    public List<PedidoCabecera> getAllPedidos() {
        return pedidoCabeceraRepository.findAll();
    }

    public PedidoCabecera getPedidoById(Integer id) {
        return pedidoCabeceraRepository.findById(id).orElse(null);
    }

    public PedidoCabecera createPedido(PedidoCabecera pedidoCabecera) {
        PedidoCabecera savedPedidoCabecera = pedidoCabeceraRepository.save(pedidoCabecera);
        if (pedidoCabecera.getDetalles() != null) {
            for (PedidoDetalle detalle : pedidoCabecera.getDetalles()) {
                detalle.setPedidoCabecera(savedPedidoCabecera);
                pedidoDetalleRepository.save(detalle);
            }
        }
        return savedPedidoCabecera;
    }

    public PedidoCabecera updatePedido(Integer id, PedidoCabecera pedidoCabecera) {
        Optional<PedidoCabecera> existingPedido = pedidoCabeceraRepository.findById(id);
        if (existingPedido.isPresent()) {
            PedidoCabecera updatedPedidoCabecera = existingPedido.get();
            updatedPedidoCabecera.setFecha(pedidoCabecera.getFecha());
            updatedPedidoCabecera.setPrecioTotal(pedidoCabecera.getPrecioTotal());
            updatedPedidoCabecera.setEsConReceta(pedidoCabecera.getEsConReceta());
            updatedPedidoCabecera.setFotoReceta(pedidoCabecera.getFotoReceta());
            updatedPedidoCabecera.setDireccionEntrega(pedidoCabecera.getDireccionEntrega());
            updatedPedidoCabecera.setDireccionReferencia(pedidoCabecera.getDireccionReferencia());
            updatedPedidoCabecera.setEstadoEntrega(pedidoCabecera.getEstadoEntrega());
            updatedPedidoCabecera.setUsuario(pedidoCabecera.getUsuario());
            pedidoCabeceraRepository.save(updatedPedidoCabecera);

            pedidoDetalleRepository.deleteAll(updatedPedidoCabecera.getDetalles());
            for (PedidoDetalle detalle : pedidoCabecera.getDetalles()) {
                detalle.setPedidoCabecera(updatedPedidoCabecera);
                pedidoDetalleRepository.save(detalle);
            }

            return updatedPedidoCabecera;
        }
        return null;
    }

    public void deletePedido(Integer id) {
        pedidoDetalleRepository.deleteAll(pedidoDetalleRepository.findByPedidoCabeceraCodPedCab(id));
        pedidoCabeceraRepository.deleteById(id);
    }
}