package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PEDIDO_DETALLE")
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer secDet;
    private Integer cantidad;
    private Double subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codPedCab")
    private PedidoCabecera pedidoCabecera;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoProducto")
    private Producto producto;



    // Getters and Setters
}