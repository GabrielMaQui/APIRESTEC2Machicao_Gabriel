package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Producto;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IProductoRepository;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Integer id, Producto producto) {
        Producto existingProducto = productoRepository.findById(id).orElse(null);
        if (existingProducto != null) {
            producto.setCodigoProducto(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}