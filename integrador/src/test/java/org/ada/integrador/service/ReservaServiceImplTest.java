package org.ada.integrador.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.ada.integrador.bo.Reserva;
import org.ada.integrador.repository.ReservaRepositoryMongo;
import org.ada.integrador.service.reserva.ReservaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

class ReservaServiceImplTest {

    @Mock
    private ReservaRepositoryMongo reservaRepositoryMongo;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearReserva() {
        Reserva reserva = new Reserva();
        reserva.setIdReserva("1");

        when(reservaRepositoryMongo.save(any(Reserva.class))).thenReturn(reserva);

        Reserva resultado = reservaService.crearReserva(reserva);

        assertEquals("1", resultado.getIdReserva());
        verify(reservaRepositoryMongo).save(reserva);
    }

    @Test
    void testBuscarReservaPorId() {
        Reserva reserva = new Reserva();
        reserva.setIdReserva("1");

        when(reservaRepositoryMongo.findById("1")).thenReturn(Optional.of(reserva));

        Reserva resultado = reservaService.buscarReservaPorId("1");

        assertEquals("1", resultado.getIdReserva());
        verify(reservaRepositoryMongo).findById("1");
    }

    @Test
    void testBuscarReservaPorIdNotFound() {
        when(reservaRepositoryMongo.findById("1")).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                reservaService.buscarReservaPorId("1")
        );

        assertEquals("Reserva no encontrada", exception.getMessage());
    }

    @Test
    void testListarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());

        when(reservaRepositoryMongo.findAll()).thenReturn(reservas);

        List<Reserva> resultado = reservaService.listarReservas();

        assertEquals(1, resultado.size());
        verify(reservaRepositoryMongo).findAll();
    }

    @Test
    void testModificarReserva() {
        Reserva reservaExistente = new Reserva();
        reservaExistente.setIdReserva("1");
        reservaExistente.setFechaReserva(LocalDateTime.of(2024, 10, 1, 12, 0));

        Reserva reservaModificada = new Reserva();
        reservaModificada.setFechaReserva(LocalDateTime.of(2024, 10, 5, 12, 0));

        when(reservaRepositoryMongo.findById("1")).thenReturn(Optional.of(reservaExistente));
        when(reservaRepositoryMongo.save(any(Reserva.class))).thenReturn(reservaExistente);

        Reserva resultado = reservaService.modificarReserva("1", reservaModificada);


        assertEquals(LocalDateTime.of(2024, 10, 5, 12, 0), resultado.getFechaReserva());
        verify(reservaRepositoryMongo).findById("1");
        verify(reservaRepositoryMongo).save(reservaExistente);
    }

    @Test
    void testEliminarReserva() {
        String idReserva = "1";

        doNothing().when(reservaRepositoryMongo).deleteById(idReserva);

        reservaService.eliminarReserva(idReserva);

        verify(reservaRepositoryMongo).deleteById(idReserva);
    }
}

