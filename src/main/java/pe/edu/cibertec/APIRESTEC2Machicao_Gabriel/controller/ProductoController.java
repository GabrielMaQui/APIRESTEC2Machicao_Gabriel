package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Producto;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }
}