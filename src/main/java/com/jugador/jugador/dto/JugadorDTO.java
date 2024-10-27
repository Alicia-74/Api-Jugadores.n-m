package com.jugador.jugador.dto;

import java.util.ArrayList;
import java.util.List;

import com.jugador.jugador.persistance.models.Jugador;
import com.jugador.jugador.persistance.models.Trofeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    
    private Long jugadorId;
    private String name;
    private List<TrofeoDTO> trofeosGanados; // Lista de trofeos en el DTO

    public JugadorDTO(Jugador j){
        this.jugadorId = j.getJugadorId();
        this.name = j.getName();
        this.trofeosGanados = convertirTrofeosATrofeoDTOs(j.getTrofeosGanados());
    }

    // Método para convertir la lista de Trofeos a TrofeoDTOs
    public List<TrofeoDTO> convertirTrofeosATrofeoDTOs(List<Trofeo> trofeos) {
        List<TrofeoDTO> trofeosGanados = new ArrayList<>();
        for (Trofeo t : trofeos) {
            trofeosGanados.add(new TrofeoDTO(t)); // Asumiendo que TrofeoDTO tiene un constructor que acepta Trofeo
        }
        return trofeosGanados;
    }
}
