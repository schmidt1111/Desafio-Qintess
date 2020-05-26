package com.qintess.ingressosonline.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.ingressosonline.entity.Usuario;
import com.qintess.ingressosonline.exception.IngressoException;
import com.qintess.ingressosonline.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}
	
	public Usuario delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
		return usuario;
	}
	public Object buscarPorId (Long id) {
		return usuarioRepository.findById(id);
	}
	public void deleteId(Long id) {
		usuarioRepository.deleteById(id);
	}
	public Usuario atualizar(Usuario usuario, Long id) {
		Usuario atualizar = usuarioRepository.findById(id).orElseThrow(() -> new IngressoException("Usuario não localizado."));
		atualizar.setNome(usuario.getNome());
		atualizar.setCpf(usuario.getCpf());
		atualizar.setEmail(usuario.getEmail());
		atualizar.setTelefone(usuario.getTelefone());
		atualizar.setSenha(usuario.getSenha());
		
		return usuarioRepository.save(atualizar);
	}
}

