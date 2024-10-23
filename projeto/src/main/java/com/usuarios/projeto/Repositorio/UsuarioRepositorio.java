package com.usuarios.projeto.Repositorio;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.usuarios.projeto.Modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, String>{
    
}
