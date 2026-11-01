package com.krakedev.proyectos.services;

import com.krakedev.proyectos.entidades.Usuario;
import com.krakedev.proyectos.repositories.UsuarioRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario guardar(Usuario usuario) {
		String contrasenaEncriptada = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(contrasenaEncriptada);
		return usuarioRepository.save(usuario);
	}

	public boolean autenticar(String username, String password) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
		return usuarioOpt.isPresent() && BCrypt.checkpw(password, usuarioOpt.get().getPassword());
	}
}