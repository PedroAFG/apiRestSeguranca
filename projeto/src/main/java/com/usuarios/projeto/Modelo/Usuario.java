package com.usuarios.projeto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    private String login;
    private String senha;

}