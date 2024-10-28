package org.ada.integrador.service.reserva;

import org.ada.integrador.bo.Reserva;

import java.util.List;

public interface ReservaService {
    Reserva crearReserva(Reserva reserva);
    Reserva buscarReservaPorId(String idReserva);
    List<Reserva> listarReservas();
    Reserva modificarReserva(String idReserva, Reserva reserva);
    void eliminarReserva(String idReserva);
}
