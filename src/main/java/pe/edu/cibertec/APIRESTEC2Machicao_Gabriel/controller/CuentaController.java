package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Cuenta;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.ICuentaService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/cuenta")
public class CuentaController {
    private ICuentaService cuentaService;

    @GetMapping("")

    public ResponseEntity<List<Cuenta>> listarCuentas() {
        return new ResponseEntity<>(
                cuentaService.listarCuenta(),
                HttpStatus.OK
        );
    }
}
