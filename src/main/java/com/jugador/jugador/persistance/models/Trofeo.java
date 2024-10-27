package com.jugador.jugador.persistance.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="trophies")
public class Trofeo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtrophie")
    private Long trofeoId;

    @Column(name="title")
    private String titulo;

    @Column(name="description")
    private String descrip;

    @ManyToMany(mappedBy = "trofeosGanados", cascade = {CascadeType.ALL})
    private List<Jugador> jug;

}
