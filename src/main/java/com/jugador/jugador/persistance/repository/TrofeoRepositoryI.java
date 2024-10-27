package com.jugador.jugador.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jugador.jugador.dto.TrofeoDTO;
import com.jugador.jugador.persistance.models.Trofeo;

public interface TrofeoRepositoryI extends JpaRepository<Trofeo, Long>{
        
    List<Trofeo> findByTitulo(String titulo);
    Trofeo findByDescrip(String descrip);
    void save(TrofeoDTO trofeo);
}
