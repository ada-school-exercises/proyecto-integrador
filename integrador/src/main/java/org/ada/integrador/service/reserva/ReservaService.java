package org.ada.integrador.service.reserva;

import org.ada.integrador.bo.Reserva;

import java.util.List;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    Reserva buscarReservaPorId(Long idReserva);
    List<Reserva> listarReservas();
    Reserva modificarReserva(Long idReserva, Reserva reserva);
    void eliminarReserva(Long idReserva);
}
