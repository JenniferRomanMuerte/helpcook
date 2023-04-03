package com.help.cook.helpcook.models;

import lombok.Data;

import java.util.List;

@Data
public class UsuariosResponse {

    private Integer idUsuarios;

    private String nick;

    private String contrasenia;

    private String nombre;

    private String apellido;

    private String email;

    private String foto;

    private List<FavoritosResponse> favoritos;

    private List<ValoracionesResponse> valoraciones;


}
