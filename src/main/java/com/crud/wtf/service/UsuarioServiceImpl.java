package com.crud.wtf.service;

import com.crud.wtf.model.Usuario;
import com.crud.wtf.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public ArrayList<Usuario> getAllUser() {
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getUserById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario saveUser(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public boolean deleteUserById(long id) {
        try {
            Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

            if (optionalUsuario.isPresent()) {
                Usuario usuario = optionalUsuario.get();
                usuario.setActivo(false);
                usuarioRepository.save(usuario); // Actualizar en la base de datos
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
