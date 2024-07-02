package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto;

import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.EstadoEntrega;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;

import java.util.List;

public record PedidoCabeceraDTO(Integer codPedCab,
                                Usuario usuario,
                                String fecha,
                                Double precioTotal,
                                Boolean esConReceta,
                                String fotoReceta,
                                String direccionEntrega,
                                String direccionReferencia,
                                EstadoEntrega estadoEntrega,
                                List<PedidoDetalleDTO> detalles) {
}
