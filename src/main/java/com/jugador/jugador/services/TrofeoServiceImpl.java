package com.jugador.jugador.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jugador.jugador.dto.TrofeoDTO;
import com.jugador.jugador.persistance.models.Trofeo;
import com.jugador.jugador.persistance.repository.TrofeoRepositoryI;

@Service
public class TrofeoServiceImpl implements TrofeoServiceI{
    
    @Autowired
    TrofeoRepositoryI trofeoRepo;
    
    @Override
    public List<TrofeoDTO> showAllTrofeo() {
        List<Trofeo> trofeoesList = trofeoRepo.findAll();
        List<TrofeoDTO> trofeoesDTOList = new ArrayList<TrofeoDTO>(); 

        for (Trofeo trofeo : trofeoesList) {
            trofeoesDTOList.add(new TrofeoDTO(trofeo));
        }

        return trofeoesDTOList;
    }

    @Override
    public List<TrofeoDTO> getTrofeoByTitulo(String titulo) {
        List<Trofeo> trofeosList = trofeoRepo.findByTitulo(titulo);
        List<TrofeoDTO> trofeosDTOList = new ArrayList<TrofeoDTO>(); 

        for (Trofeo trofeo : trofeosList) {
            trofeosDTOList.add(new TrofeoDTO(trofeo));
        }

        return trofeosDTOList;
    }

    public Trofeo getTrofeoById(Long id) {
        return trofeoRepo.findById(id).get(); //".get()" para q coga los Trofeoes con el id q corresponda al hacer el join con la otra tabla
    }

    public Trofeo getTrofeoByDescrip(String descrip) {
        return trofeoRepo.findByDescrip(descrip); 
    }

    @Override
    public void insertTrofeo(TrofeoDTO t) {
         //Crear Trofeo a partir del DTO
         Trofeo newTrofeo = new Trofeo();
         newTrofeo.setTrofeoId(t.getTrofeoId());
         newTrofeo.setTitulo(t.getTitulo());
         newTrofeo.setDescrip(t.getDescrip());
         //Guardar Trofeo
         trofeoRepo.save(newTrofeo);
    }


    

    @Override
    public void saveTrofeo(TrofeoDTO trofeo) {
        trofeoRepo.save(trofeo);
    }


    @Override
    public void updateTrofeo(Long id, TrofeoDTO trofeo) {
        trofeo.setTrofeoId(id);
        trofeoRepo.save(trofeo);
    }

    @Override
    public void deleteTrofeo(Long id) {
        trofeoRepo.deleteById(id);    
    }

}
