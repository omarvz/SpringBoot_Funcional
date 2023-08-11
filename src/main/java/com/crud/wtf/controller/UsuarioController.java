package com.crud.wtf.controller;

import com.crud.wtf.model.Usuario;
import com.crud.wtf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RequestMapping("api")
@RestController
public class UsuarioController {
    @GetMapping("/saludar")
    public String saludar(){
        return "Hola mundo";
    }

    @PostMapping("/saludar")
    public String postSaludar(){
        return "Post saludar";
    }

    @Autowired
    UsuarioService usuarioService; //Se inyecta siempre la interfaz, no la implementación de la interfaz.

    @GetMapping("/all")
    public ArrayList<Usuario> getAllUser(){
        return usuarioService.getAllUser();
    }

    @GetMapping("/find/{id}")
    public Optional<Usuario> getUserById(@PathVariable("id") long id){
        return usuarioService.getUserById(id);
    }

    @PostMapping("/save")
    public Usuario saveUser(@RequestBody Usuario u){
        return usuarioService.saveUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        if (usuarioService.deleteUserById(id)) {
            return "Se ha eliminado el usuario";
        } else {
            return "No se ha eliminado el usuario";
        }
    }
}
