package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
