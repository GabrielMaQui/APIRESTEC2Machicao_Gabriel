package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
