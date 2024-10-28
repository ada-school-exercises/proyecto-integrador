package org.ada.integrador.controller;

import org.ada.integrador.bo.Reserva;
import org.ada.integrador.service.reserva.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return new ResponseEntity<>(nuevaReserva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        List<Reserva> reservas = reservaService.listarReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{idReserva}")
    public ResponseEntity<Reserva> buscarReserva(@PathVariable String idReserva) {
        Reserva reserva = reservaService.buscarReservaPorId(idReserva);
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PutMapping("/{idReserva}")
    public ResponseEntity<Reserva> modificarReserva(@PathVariable String idReserva, @RequestBody Reserva reserva) {
        Reserva reservaModificada = reservaService.modificarReserva(idReserva, reserva);
        return new ResponseEntity<>(reservaModificada, HttpStatus.OK);
    }

    @DeleteMapping("/{idReserva}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable String idReserva) {
        reservaService.eliminarReserva(idReserva);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
