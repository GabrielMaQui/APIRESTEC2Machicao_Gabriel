package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
