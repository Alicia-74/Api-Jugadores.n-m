package com.jugador.jugador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jugador.jugador.dto.JugadorDTO;
import com.jugador.jugador.services.JugadorServiceI;

@RestController
@RequestMapping("/api/v1/jugador")
@CrossOrigin
public class JugadorController {
    
    @Autowired
    private JugadorServiceI jugadorMngmnt;

    @GetMapping
    public List<JugadorDTO> getAllJugadores() {
        return jugadorMngmnt.showAllJugadores();
    }

    @GetMapping("/name/{username}")
    public List<JugadorDTO> getJugadorByName(@PathVariable String username) {
        return jugadorMngmnt.getJugadorByName(username);
    }

    @PostMapping("/insert")
    public void insertJugador(@RequestBody JugadorDTO jugador) {
        jugadorMngmnt.insertJugador(jugador);
    }

    @PostMapping("/{jugadorId}/trofeos/{trofeoId}")
    public ResponseEntity<JugadorDTO> otorgarTrofeoAJugador(@PathVariable Long jugadorId, @PathVariable Long trofeoId) {
        // ResponseEntity permite enviar el objeto actualizado junto con el código HTTP adecuado (200 OK) al cliente.
        JugadorDTO updatedJugador = jugadorMngmnt.otorgarTrofeoAJugador(jugadorId, trofeoId);
        return ResponseEntity.ok(updatedJugador);
    }

    @PutMapping("edit/{id}")
    public String editJugador(@PathVariable Long id, @RequestBody JugadorDTO jugador) {
        jugadorMngmnt.updateJugador(id, jugador);
        return "Jugador modified";
    }

    @DeleteMapping("delete/{id}")
    public String deleteJugador(@PathVariable Long id) {
        jugadorMngmnt.deleteJugador(id);
        return "Jugador deleted";
    }
}
