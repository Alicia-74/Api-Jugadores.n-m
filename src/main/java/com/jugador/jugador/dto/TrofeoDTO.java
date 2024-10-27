package com.jugador.jugador.dto;

import com.jugador.jugador.persistance.models.Trofeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrofeoDTO {
    private Long trofeoId;
    private String titulo;
    private String descrip;

    public TrofeoDTO(Trofeo t){
        this.trofeoId = t.getTrofeoId();
        this.titulo = t.getTitulo();
        this.descrip = t.getDescrip();
    }
}
