package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "PEDIDO_CABECERA")
public class PedidoCabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPedCab;
    @ManyToOne
    @JoinColumn(name = "codigoUsuario")
    private Usuario usuario;
    private Date fecha;
    private Double precioTotal;
    private Boolean esConReceta;
    private String fotoReceta;
    private String direccionEntrega;
    private String direccionReferencia;
    @ManyToOne
    @JoinColumn(name = "codEstEnt")
    private EstadoEntrega estadoEntrega;
    @OneToMany(mappedBy = "pedidoCabecera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoDetalle> detalles;
}