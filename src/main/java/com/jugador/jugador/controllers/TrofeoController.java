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


import com.jugador.jugador.dto.TrofeoDTO;
import com.jugador.jugador.services.TrofeoServiceI;

@RestController
@RequestMapping("/api/v1/trofeo")
@CrossOrigin
public class TrofeoController {
    
    @Autowired
    private TrofeoServiceI trofeoMngmnt;

    @GetMapping
    public List<TrofeoDTO> getAllTrofeo() {
        return trofeoMngmnt.showAllTrofeo();
    }

    @GetMapping("/title/{titulo}")
    public List<TrofeoDTO> getTrofeoByTitulo(@PathVariable String titulo) {
        return trofeoMngmnt.getTrofeoByTitulo(titulo);
    }

    @PostMapping("/insert")
    public void insertTrofeo(@RequestBody TrofeoDTO trofeo) {
        trofeoMngmnt.insertTrofeo(trofeo);
    }


    @PutMapping("edit/{id}")
    public String editTrofeo(@PathVariable Long id, @RequestBody TrofeoDTO trofeo) {
        trofeoMngmnt.updateTrofeo(id, trofeo);
        return "Trofeo modified";
    }

    @DeleteMapping("delete/{id}")
    public String deleteTrofeo(@PathVariable Long id) {
        trofeoMngmnt.deleteTrofeo(id);
        return "Trofeo deleted";
    }
}
