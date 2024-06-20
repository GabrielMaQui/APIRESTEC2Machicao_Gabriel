package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EstadoEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEstEnt;
    private String nombreEstado;


}
