package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Persona;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.IPersonaService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/persona")
public class PersonaController {
    private IPersonaService personaService;

    @GetMapping("")
    public ResponseEntity<List<Persona>> listar() {
        return new ResponseEntity<>(
                personaService.listarPersona(),
                HttpStatus.OK
        );
    }
}
