package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.UsuarioService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return new ResponseEntity<>(usuarioService.getAllUsuarios(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{codigoUsuario}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer codigoUsuario, @RequestBody Usuario usuarioDetails) {
        Usuario updatedUsuario = usuarioService.updateUsuario(codigoUsuario, usuarioDetails);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/{codigoUsuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer codigoUsuario) {
        usuarioService.deleteUsuario(codigoUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}