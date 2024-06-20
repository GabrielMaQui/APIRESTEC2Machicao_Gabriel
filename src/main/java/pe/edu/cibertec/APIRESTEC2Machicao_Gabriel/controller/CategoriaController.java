package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Categoria;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Integer id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
    }
}
