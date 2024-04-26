package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.dto;


import lombok.Data;

import java.util.Date;

@Data
public class CuentaRequestDto {

    private String nrocuenta;
    private Date fecharegistro;
    private Date fechavencimiento;

}
