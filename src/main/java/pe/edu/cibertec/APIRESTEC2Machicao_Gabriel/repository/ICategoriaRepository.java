package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
