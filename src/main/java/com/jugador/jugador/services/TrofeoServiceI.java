package com.jugador.jugador.services;

import java.util.List;

import com.jugador.jugador.dto.TrofeoDTO;
import com.jugador.jugador.persistance.models.Trofeo;

public interface TrofeoServiceI {

    List<TrofeoDTO> showAllTrofeo();
    List<TrofeoDTO> getTrofeoByTitulo(String titulo);
    Trofeo getTrofeoByDescrip(String descrip);
    void insertTrofeo(TrofeoDTO trofeo);
    void saveTrofeo(TrofeoDTO trofeo);
    void updateTrofeo(Long id, TrofeoDTO trofeo);
    void deleteTrofeo(Long id);
    Trofeo getTrofeoById(Long id);
}
