package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ESTADO_ENTREGA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class EstadoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEstEnt;
    private String nombreEstado;


}
