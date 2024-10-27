package com.jugador.jugador.persistance.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="players")
public class Jugador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idplayer")
    private Long jugadorId;

    @Column(name="username")
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "players_has_trophies",
        joinColumns = {@JoinColumn(name = "players_idplayer", referencedColumnName = "idplayer")}, // Referencia a la tabla players
        inverseJoinColumns = {@JoinColumn(name = "trophies_idtrophie", referencedColumnName = "idtrophie")} // Referencia a la tabla trophies
    )

    private List<Trofeo> trofeosGanados;
}
