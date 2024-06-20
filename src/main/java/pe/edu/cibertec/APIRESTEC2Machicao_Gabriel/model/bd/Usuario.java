package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "esAdmin")
    private Boolean esAdmin;

    @Column(name = "esBloqueado")
    private Boolean esBloqueado;

    @Column(name = "esAutenticado")
    private Boolean esAutenticado;
}