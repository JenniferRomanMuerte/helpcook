package com.help.cook.helpcook.models;

import java.sql.Time;
import java.util.List;

import lombok.Data;

@Data
public class RecetasResponse {

    private Integer idRecetas;

    private Integer idUsuarios;

    private String descripcion;

    private Float tiempo;

    private String foto;

    private String tipo;

    private String categoria;

    private Time fecha_alta;

    private Float valoracionMedia;

    private Integer comensales;

    private List<IngredientesResponse> ingredientesResponse;

}
