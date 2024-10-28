package org.ada.integrador.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "reservas")
public class Reserva {

    @Id
    private String idReserva;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaDevolucion;
    private String idUsuario;

    public Reserva() {
    }


    public Reserva(String idReserva, LocalDateTime fechaReserva, LocalDateTime fechaDevolucion, String idUsuario) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
        this.idUsuario = idUsuario;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fechaReserva=" + fechaReserva +
                ", fechaDevolucion=" + fechaDevolucion +
                ", idUsuario=" + idUsuario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(idReserva, reserva.idReserva) && Objects.equals(fechaReserva, reserva.fechaReserva) && Objects.equals(fechaDevolucion, reserva.fechaDevolucion) && Objects.equals(idUsuario, reserva.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReserva, fechaReserva, fechaDevolucion, idUsuario);
    }
}
