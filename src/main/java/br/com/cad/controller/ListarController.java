package br.com.cad.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.cad.model.Usuario;
import br.com.cad.service.UsuarioService;
import br.com.cad.utils.Const;

@Controller
public class ListarController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(path = "listar")
	public ModelAndView index(ModelAndView model) {
		List<Usuario> listaUsuarios = usuarioService.findAll();
		model.addObject("listaUsuarios", listaUsuarios);
		
		if (listaUsuarios.isEmpty()) {
			model.addObject("vazio", "Não há usuários cadastrados");
			model.setViewName("listar");
			return model;
		} else {
			return model;
		}
	}
	
	@GetMapping(path = "/deletar/{id}")
	public ModelAndView deletar(@PathVariable(value = "id") Long id, ModelAndView model, RedirectAttributes redirAttrs) {
		usuarioService.deleteById(id);
		
		model.setViewName("redirect:/listar");
		redirAttrs.addFlashAttribute("sucessoExclusao", "Usuário excluído com sucesso");
		
		return model;
	}
	
	@GetMapping(path = "/chamarAlterar/{id}")
	public ModelAndView chamarAlterar(@PathVariable(value = "id") Long id, ModelAndView model) {
		Const.ID_USUARIO_EDITAR = id;
		
		model.setViewName("redirect:/alterar");
		
		return model;
	}
}
