package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Cuenta;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.CuentaRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CuentaService implements ICuentaService {

    private CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> listarCuenta() {
        return cuentaRepository.findAll();
    }
}
