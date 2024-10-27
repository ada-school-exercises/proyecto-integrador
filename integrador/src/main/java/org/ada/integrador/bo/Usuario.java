package org.ada.integrador.bo;

import java.util.Objects;

public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String apellido, String correo, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(idUsuario, usuario1.idUsuario) && Objects.equals(nombre, usuario1.nombre) && Objects.equals(apellido, usuario1.apellido) && Objects.equals(correo, usuario1.correo) && Objects.equals(usuario, usuario1.usuario) && Objects.equals(contrasena, usuario1.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, apellido, correo, usuario, contrasena);
    }
}
