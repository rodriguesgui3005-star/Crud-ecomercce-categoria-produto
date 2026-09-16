package com.biolab.ecommercebiolab.services;

import com.biolab.ecommercebiolab.DTOs.UsuarioDTO;
import com.biolab.ecommercebiolab.entities.Usuario;
import com.biolab.ecommercebiolab.entities.enums.Role;
import com.biolab.ecommercebiolab.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public String criarUsuario(UsuarioDTO u){
        Usuario usuario = new Usuario();
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(u.getSenha());
        usuario.setTelefone(u.getTelefone());
        usuario.setRoles(Role.USER);
        repo.save(usuario);
        return "Usuario criado com sucesso!!";
    }
}
