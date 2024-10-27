package org.ada.integrador.service.reserva;

import org.ada.integrador.bo.Reserva;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final HashMap<Long, Reserva> reservas = new HashMap<>();
    private Long id = 0L;

    @Override
    public Reserva crearReserva(Reserva reserva) {
        reserva.setIdReserva(id++);
        reservas.put(reserva.getIdReserva(), reserva);
        return reserva;
    }

    @Override
    public Reserva buscarReservaPorId(Long idReserva) {
        return reservas.get(idReserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return new ArrayList<>(reservas.values());
    }

    @Override
    public Reserva modificarReserva(Long idReserva, Reserva reserva) {
        if(reservas.containsKey(idReserva)){
            reserva.setIdReserva(idReserva);
            reservas.put(reserva.getIdReserva(), reserva);
            return reserva;
        }
        throw new IllegalArgumentException("Reserva no encontrada con el id " + idReserva);
    }

    @Override
    public void eliminarReserva(Long idReserva) {
        reservas.remove(idReserva);
    }
}
