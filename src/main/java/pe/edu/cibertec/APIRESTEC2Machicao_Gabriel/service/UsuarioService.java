package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.Usuario;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.repository.IUsuarioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private IUsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Integer codigoUsuario, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(codigoUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario not found with id " + codigoUsuario));

        usuario.setNombreUsuario(usuarioDetails.getNombreUsuario());
        usuario.setCorreo(usuarioDetails.getCorreo());
        usuario.setContrasena(usuarioDetails.getContrasena());
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellido(usuarioDetails.getApellido());
        usuario.setTelefono(usuarioDetails.getTelefono());
        usuario.setDireccion(usuarioDetails.getDireccion());
        usuario.setFechaNacimiento(usuarioDetails.getFechaNacimiento());
        usuario.setGenero(usuarioDetails.getGenero());
        usuario.setEsAdmin(usuarioDetails.getEsAdmin());
        usuario.setEsBloqueado(usuarioDetails.getEsBloqueado());
        usuario.setEsAutenticado(usuarioDetails.getEsAutenticado());

        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}