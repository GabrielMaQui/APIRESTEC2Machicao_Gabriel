package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoCabecera;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoDetalle;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Producto;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IPedidoCabeceraRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IPedidoDetalleRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IProductoRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private IPedidoCabeceraRepository pedidoCabeceraRepository;

    @Autowired
    private IPedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IProductoRepository productoRepository;

    public List<PedidoCabecera> obtenerTodosLosPedidos() {
        return pedidoCabeceraRepository.findAll();
    }

    public Optional<PedidoCabecera> obtenerPedidoPorId(Integer id) {
        return pedidoCabeceraRepository.findById(id);
    }

    public PedidoCabecera guardarPedido(PedidoCabecera pedidoCabecera) {

        Integer usuarioId = pedidoCabecera.getUsuario().getCodigoUsuario();
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + usuarioId));
        pedidoCabecera.setUsuario(usuario);


        for (PedidoDetalle detalle : pedidoCabecera.getDetalles()) {
            Integer productoId = detalle.getProducto().getCodigoProducto();
            Producto producto = productoRepository.findById(productoId)
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + productoId));
            detalle.setProducto(producto);
        }

        // Guardar la cabecera del pedido
        PedidoCabecera savedPedidoCabecera = pedidoCabeceraRepository.save(pedidoCabecera);

        // Asignar la cabecera a los detalles y guardarlos
        pedidoCabecera.getDetalles().forEach(detalle -> {
            detalle.setPedidoCabecera(savedPedidoCabecera);
            pedidoDetalleRepository.save(detalle);
        });

        return savedPedidoCabecera;
    }


    public void eliminarPedido(Integer id) {
        pedidoCabeceraRepository.deleteById(id);
    }

    public List<PedidoDetalle> obtenerDetallesPorPedidoId(Integer pedidoId) {
        return pedidoDetalleRepository.findByPedidoCabeceraCodPedCab(pedidoId);
    }
}