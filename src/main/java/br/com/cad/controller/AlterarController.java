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
import br.com.cad.utils.Const;

@Controller
public class AlterarController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "alterar")
	public ModelAndView index(ModelAndView model) {
		Usuario usuario = usuarioService.findById(Const.ID_USUARIO_EDITAR);
		
		model.addObject("usuario", usuario);
		model.setViewName("alterar");
		
		return model;
	}
	
	@PostMapping(path = "/alterar")
	public ModelAndView alterar(@ModelAttribute("usuario") Usuario usuario, ModelAndView model, RedirectAttributes redirAttrs) {
		usuarioService.update(usuario, usuario.getId());
		
		model.setViewName("redirect:/listar");
		redirAttrs.addFlashAttribute("sucessoAlteracao", "Usuário alterado com sucesso");
		
		return model;
	}
}
