package com.jugador.jugador.services;

import java.util.List;

import com.jugador.jugador.dto.JugadorDTO;
import com.jugador.jugador.persistance.models.Jugador;

public interface JugadorServiceI {

    List<JugadorDTO> showAllJugadores();
    List<JugadorDTO> getJugadorByName(String name);
    void insertJugador(JugadorDTO jugador);
    void updateJugador(Long id, JugadorDTO jugador);
    void deleteJugador(Long id);
    Jugador getJugadorById(Long id);
    JugadorDTO otorgarTrofeoAJugador(Long jugadorId, Long trofeoId);
}
