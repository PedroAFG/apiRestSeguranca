package com.usuarios.projeto.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.projeto.Modelo.Usuario;
import com.usuarios.projeto.Repositorio.UsuarioRepositorio;
import com.usuarios.projeto.Util.MD5Util;

@RestController
public class Controle {
    
    @Autowired
    private UsuarioRepositorio acao;

    //Cadastro de usuarios
    @PostMapping("/")
    public Usuario cadastrar(@RequestBody Usuario u){
        u.setSenha(MD5Util.hash(u.getSenha()));
        return acao.save(u);
    }

    //Teste pra listar os usuarios ja criados
    @GetMapping("/")
    public Iterable<Usuario> listar(){
        return acao.findAll();
    }

    //Função de login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        //Validaçao de usuario, busca usuario cm o findByID
        Usuario u = acao.findById(usuario.getLogin()).orElse(null);
        
        if (u == null || !u.getSenha().equals(MD5Util.hash(usuario.getSenha()))) {
            //Caso senha ou usuario estiver incorreto
            return new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
        }

        //Tendo credenciais validas
        return new ResponseEntity<>("Logado com sucesso", HttpStatus.OK);
    }

    //Remover usuario
    @DeleteMapping("/{login}")
    public void remover(@PathVariable String login){
        acao.deleteById(login);
    }

}
