package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PersonaRequestDto {

    private String nombrepersona;
    private String apepersona;
    private List<CuentaRequestDto> cuentas = new ArrayList<>();
}
