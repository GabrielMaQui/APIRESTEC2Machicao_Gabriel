package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "CATEGORIA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCategoria;
    private String nombreCategoria;
}