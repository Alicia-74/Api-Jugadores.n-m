package com.jugador.jugador.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jugador.jugador.dto.JugadorDTO;
import com.jugador.jugador.persistance.models.Jugador;

@Repository
public interface JugadorRepositoryI extends JpaRepository<Jugador, Long>{
    
    List<Jugador> findByName(String name);
    void save(JugadorDTO jugador);

}
