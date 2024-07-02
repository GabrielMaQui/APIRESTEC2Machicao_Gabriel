package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto;

public record PedidoDetalleDTO(Integer secDet,
                               Integer cantidad,
                               Double subtotal,
                               ProductoDTO producto) {
}
