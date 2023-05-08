package com.help.cook.helpcook.models;

import lombok.Data;


/**
 * Objeto para recibir datos del front
 * @author Jennifer
 *@version 1.0, 2022/11/05
 */
@Data
public class RecetasIngredientesRequest {

    private Integer idIngredientes;

    private String cantidad;
}
