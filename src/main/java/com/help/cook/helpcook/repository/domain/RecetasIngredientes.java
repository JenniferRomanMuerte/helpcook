package com.help.cook.helpcook.repository.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name =  "recetas_ingredientes")
public class RecetasIngredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Rec_Ingr")
    private Integer id;
/*
    @Column(name = "ID_Recetas")
    Integer idRecetas;

    @Column(name = "ID_Ingredientes")
    private Integer idIngredientes;
*/

    @ManyToOne
    @JoinColumn(name = "ID_Recetas")
    Recetas recetas;

    @ManyToOne
    @JoinColumn(name = "ID_Ingredientes")
    Ingredientes ingredientes;

    private String cantidad;



}
