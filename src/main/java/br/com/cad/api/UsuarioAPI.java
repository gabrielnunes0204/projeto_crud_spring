package br.com.cad.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cad.model.Usuario;
import br.com.cad.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioAPI {

	@Autowired
	private UsuarioService usuarioService;
	
	//CONSULTANDO TODOS OS USUÁRIOS
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> listaUsuarios = usuarioService.findAll();
		
		return ResponseEntity.ok().body(listaUsuarios);		
	}
	
	//CONSULTANDO USUÁRIO POR ID
	@GetMapping(path = "/consultar/{id}")
	public ResponseEntity<Usuario> consultar(@PathVariable(value = "id") Long id) {
		Usuario usuario = usuarioService.findById(id);
		
		return ResponseEntity.ok().body(usuario);
	}
	
	//CRIANDO O USUÁRIO
	@PostMapping(path = "/criar")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		usuarioService.create(usuario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}
	
	//EXCLUÍNDOO O USUÁRIO
	@GetMapping(path = "/deletar/{id}")
	public ResponseEntity<Usuario> deletar(@PathVariable(value = "id") Long id) {
		usuarioService.findById(id);
		usuarioService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	//ALTERANDO O USUÁRIO
	@PostMapping(path = "/alterar/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> alterar(@PathVariable(value = "id") Long id, @RequestBody Usuario usuario) {
		Usuario user = usuarioService.findById(id);
		
		user.setNome(usuario.getNome());
		user.setIdade(usuario.getIdade());
		user.setEmail(usuario.getEmail());
		user.setSenha(usuario.getSenha());
		
		usuarioService.create(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
