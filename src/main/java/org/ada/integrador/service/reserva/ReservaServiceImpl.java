package org.ada.integrador.service.reserva;

import org.ada.integrador.bo.Reserva;
import org.ada.integrador.repository.ReservaRepositoryMongo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepositoryMongo reservaRepositoryMongo;

    public ReservaServiceImpl(ReservaRepositoryMongo reservaRepositoryMongo) {
        this.reservaRepositoryMongo = reservaRepositoryMongo;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepositoryMongo.save(reserva);
    }

    @Override
    public Reserva buscarReservaPorId(String idReserva) {
        return reservaRepositoryMongo.findById(idReserva)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepositoryMongo.findAll();
    }

    @Override
    public Reserva modificarReserva(String idReserva, Reserva reserva) {
        Reserva reservaEncontrada = reservaRepositoryMongo.findById(idReserva)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));
        reservaEncontrada.setFechaReserva(reserva.getFechaReserva());
        reservaEncontrada.setFechaDevolucion(reserva.getFechaDevolucion());
        reservaEncontrada.setIdUsuario(reserva.getIdUsuario());
        return reservaRepositoryMongo.save(reservaEncontrada);
    }

    @Override
    public void eliminarReserva(String idReserva) {
        reservaRepositoryMongo.deleteById(idReserva);
    }
}
