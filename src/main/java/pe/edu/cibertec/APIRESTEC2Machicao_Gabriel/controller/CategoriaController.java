package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Categoria;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        return new ResponseEntity<>(categoriaService.getAllCategorias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
        return new ResponseEntity<>(categoriaService.getCategoriaById(id), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria categoriaCreated = categoriaService.createCategoria(categoria);
        return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Categoria>  updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        Categoria categoriaEdit = categoriaService.updateCategoria(id, categoria);
        return new ResponseEntity<>(categoriaEdit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
    }
}
