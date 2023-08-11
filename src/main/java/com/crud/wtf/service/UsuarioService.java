package com.crud.wtf.service;

import com.crud.wtf.model.Usuario;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioService {
    ArrayList<Usuario> getAllUser();
    Optional<Usuario> getUserById(long id);
    Usuario saveUser(Usuario u);
    boolean deleteUserById(long id);
}
