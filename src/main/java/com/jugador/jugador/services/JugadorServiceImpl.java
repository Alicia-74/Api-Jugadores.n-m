package com.jugador.jugador.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jugador.jugador.dto.JugadorDTO;
import com.jugador.jugador.dto.TrofeoDTO;
import com.jugador.jugador.persistance.models.Jugador;
import com.jugador.jugador.persistance.models.Trofeo;
import com.jugador.jugador.persistance.repository.JugadorRepositoryI;
import com.jugador.jugador.persistance.repository.TrofeoRepositoryI;

@Service
public class JugadorServiceImpl implements JugadorServiceI {

    @Autowired
    JugadorRepositoryI jugadorRepo;

    @Autowired
    TrofeoRepositoryI trofeoRepo; // Agregar la dependencia del repositorio de Trofeo

    @Override
    public List<JugadorDTO> showAllJugadores() {
        List<Jugador> jugadoresList = jugadorRepo.findAll();
        List<JugadorDTO> jugadoresDTOList = new ArrayList<>();

        for (Jugador jugador : jugadoresList) {
            jugadoresDTOList.add(new JugadorDTO(jugador));
        }

        return jugadoresDTOList;
    }

    @Override
    public List<JugadorDTO> getJugadorByName(String name) {
        List<Jugador> jugadoresList = jugadorRepo.findByName(name);
        List<JugadorDTO> jugadoresDTOList = new ArrayList<>();

        for (Jugador jugador : jugadoresList) {
            jugadoresDTOList.add(new JugadorDTO(jugador));
        }

        return jugadoresDTOList;
    }

    public Jugador getJugadorById(Long id) {
        return jugadorRepo.findById(id).get(); 
    }

    @Override
    public void insertJugador(JugadorDTO j) {
        // Crear jugador a partir del DTO
        Jugador newJugador = new Jugador();
        newJugador.setJugadorId(j.getJugadorId());
        newJugador.setName(j.getName());
        List<Trofeo> trofeosGanados = new ArrayList<>();

        // Inicializar la colección de trofeos ganados
        if (j.getTrofeosGanados() != null) {
            for (TrofeoDTO trofeoDTO : j.getTrofeosGanados()) {
                Trofeo trofeo = new Trofeo();
                trofeo.setTitulo(trofeoDTO.getTitulo());
                trofeosGanados.add(trofeo);
            }
        }
        newJugador.setTrofeosGanados(trofeosGanados); // setear la lista de trofeos ganados

        // Guardar jugador
        jugadorRepo.save(newJugador);
    }

    @Override
    public void updateJugador(Long id, JugadorDTO jugador) {
        // Actualizar información del jugador
        jugador.setJugadorId(id);
        jugadorRepo.save(jugador);
    }

    @Override
    public void deleteJugador(Long id) {
        jugadorRepo.deleteById(id);
    }

    @Override
    public JugadorDTO otorgarTrofeoAJugador(Long jugadorId, Long trofeoId) {
        // Obtener el jugador y el trofeo por sus ID
        Jugador jugador = jugadorRepo.findById(jugadorId).get();
        Trofeo trofeo = trofeoRepo.findById(trofeoId).get();

        // Agregar el trofeo a la lista de trofeos ganados del jugador
        jugador.getTrofeosGanados().add(trofeo);
        jugadorRepo.save(jugador); // Guardar los cambios

        return new JugadorDTO(jugador); // Devolver el jugador actualizado
    }
}
