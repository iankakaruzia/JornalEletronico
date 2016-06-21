package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.model.Papel;

@Transactional
@Controller
public class PapelController {
	
	@Autowired
	private PapelDAO pDAO;

	public PapelController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/inserirPapelFormulario")
	public String inserirPapelFormulario(){
		return "papel/inserirPapelFormulario";
	}
	
	@RequestMapping("/inserirPapel")
	public String inserirPapel(Papel papel){
		this.pDAO.inserir(papel);
		return "cadastroOK";
	}
	
	@RequestMapping("/listarPapel")
	public String listarPapel(Model model){
		List<Papel> papeis = this.pDAO.listar();
		model.addAttribute("papeis", papeis);
		return "redirect:/";
	}
}
