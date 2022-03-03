package br.com.cad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cad.model.Usuario;
import br.com.cad.service.UsuarioService;

@Controller
public class CadastroController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "/cadastrar")
	public ModelAndView index(ModelAndView model) {
		model.setViewName("cadastrar");
		
		return model;
	}
	
	@PostMapping(path = "/criar")
	public ModelAndView criar(@ModelAttribute("usuario") Usuario usuario, ModelAndView model, RedirectAttributes redirAttrs) {
		Usuario user = new Usuario(usuario.getNome(), usuario.getIdade(), usuario.getEmail(), usuario.getSenha());
		
		usuarioService.create(user);
		model.setViewName("redirect:/");
		redirAttrs.addFlashAttribute("sucessoCadastro", "Usuário cadastrado com sucesso");
		
		return model;
	}
}
