package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Table(name = "PRODUCTO")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

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