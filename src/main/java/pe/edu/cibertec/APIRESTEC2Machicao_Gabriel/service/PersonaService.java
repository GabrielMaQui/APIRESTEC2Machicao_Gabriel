package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Persona;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.PersonaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonaService implements IPersonaService{

    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listarPersona() {
        return personaRepository.findAll();
    }
}
