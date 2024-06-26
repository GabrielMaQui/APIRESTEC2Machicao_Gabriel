package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoProducto;
    private String nombreProducto;
    private String descripcion;
    private Double precio;
    private Integer cantidadStock;
    private String imagen;
    private String marca;
    @ManyToOne
    @JoinColumn(name = "codigoCategoria")
    private Categoria categoria;

    // Getters and Setters
}