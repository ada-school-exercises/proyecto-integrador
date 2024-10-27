package org.ada.integrador.bo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {
    private Long idReserva;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaDevolucion;
    private Long idUsuario;

    public Reserva() {
    }


    public Reserva(Long idReserva, LocalDateTime fechaReserva, LocalDateTime fechaDevolucion, Long idUsuario) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
        this.idUsuario = idUsuario;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
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
