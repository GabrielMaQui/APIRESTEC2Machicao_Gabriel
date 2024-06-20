package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Categoria;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.ICategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria getCategoriaById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Integer id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id).orElse(null);
        if (existingCategoria != null) {
            categoria.setCodigoCategoria(id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}