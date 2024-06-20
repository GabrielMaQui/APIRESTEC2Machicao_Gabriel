package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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