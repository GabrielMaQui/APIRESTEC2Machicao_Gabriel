package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoCabecera;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoDetalle;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Producto;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto.PedidoCabeceraDTO;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto.PedidoDetalleDTO;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto.ProductoDTO;
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

    public List<PedidoCabeceraDTO> obtenerTodosLosPedidos() {
        List<PedidoCabecera> pedidos = pedidoCabeceraRepository.findAll();
        return pedidos.stream().map(this::convertToDTO).toList();
    }

    public Optional<PedidoCabecera> obtenerPedidoPorId(Integer id) {
        return pedidoCabeceraRepository.findById(id);
    }

    public PedidoCabeceraDTO guardarPedido(PedidoCabecera pedidoCabecera) {
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

        PedidoCabecera savedPedidoCabecera = pedidoCabeceraRepository.save(pedidoCabecera);

        pedidoCabecera.getDetalles().forEach(detalle -> {
            detalle.setPedidoCabecera(savedPedidoCabecera);
            pedidoDetalleRepository.save(detalle);
        });

        return convertToDTO(savedPedidoCabecera);
    }

    public List<PedidoCabeceraDTO> listarPedidos() {
        List<PedidoCabecera> pedidos = pedidoCabeceraRepository.findAll();
        return pedidos.stream().map(this::convertToDTO).toList();
    }

    public void eliminarPedido(Integer id) {
        pedidoCabeceraRepository.deleteById(id);
    }

    public List<PedidoDetalle> obtenerDetallesPorPedidoId(Integer pedidoId) {
        return pedidoDetalleRepository.findByPedidoCabeceraCodPedCab(pedidoId);
    }

    private PedidoCabeceraDTO convertToDTO(PedidoCabecera pedidoCabecera) {
        return new PedidoCabeceraDTO(
                pedidoCabecera.getCodPedCab(),
                pedidoCabecera.getUsuario(),
                pedidoCabecera.getFecha().toString(),
                pedidoCabecera.getPrecioTotal(),
                pedidoCabecera.getEsConReceta(),
                pedidoCabecera.getFotoReceta(),
                pedidoCabecera.getDireccionEntrega(),
                pedidoCabecera.getDireccionReferencia(),
                pedidoCabecera.getEstadoEntrega(),
                pedidoCabecera.getDetalles().stream().map(this::convertToDTO).toList()
        );
    }

    private PedidoDetalleDTO convertToDTO(PedidoDetalle pedidoDetalle) {
        return new PedidoDetalleDTO(
                pedidoDetalle.getSecDet(),
                pedidoDetalle.getCantidad(),
                pedidoDetalle.getSubtotal(),
                convertToDTO(pedidoDetalle.getProducto())
        );
    }

    private ProductoDTO convertToDTO(Producto producto) {
        return new ProductoDTO(
                producto.getCodigoProducto(),
                producto.getNombreProducto(),
                producto.getPrecio()
        );
    }
}