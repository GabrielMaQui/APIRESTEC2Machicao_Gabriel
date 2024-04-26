package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;
    private String nompersona;
    private String apepersona;
    private Date fechnacpersona;
}
