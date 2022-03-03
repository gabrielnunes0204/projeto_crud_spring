package br.com.cad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cad.model.Usuario;
import br.com.cad.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//SALVANDO O USUÁRIO
	public Usuario create(Usuario usuario) {
		if (usuario != null) {
			return usuarioRepository.save(usuario);
		} else {
			return null;
		}
	}
	
	//DELETANDO O USUÁRIO
	public boolean deleteById(Long id) {
		Usuario usuario = findById(id);
		
		if (usuario != null) {
			usuarioRepository.delete(usuario);
			return true;
		} else {
			return false;
		}
	}
	
	//ALTERANDO O USUÁRIO
	public Usuario update(Usuario usuario, Long id) {
		Optional<Usuario> found = usuarioRepository.findById(id);
		
		found.get().setNome(usuario.getNome());
		found.get().setIdade(usuario.getIdade());
		found.get().setEmail(usuario.getEmail());
		found.get().setSenha(usuario.getSenha());
		
		usuarioRepository.save(usuario);
		
		return usuario;
	}
	
	//BUSCANDO TODOS OS USUÁRIOS
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	//BUSCANDO O USUÁRIO PELO ID
	public Usuario findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return usuario.get();
	}
}
