package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	private SecaoDAO sDAO;

	public SecaoController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "secao/inserirSecaoFormulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(Secao secao, HttpSession session){
		if(session != null && secao.getDescricao() != null && secao.getTitulo() != null){
			this.sDAO.inserir(secao);
			return "redirect:listarSecao";
		}
		return "redirect:inserirSecaoFormulario";
	}
	
	@RequestMapping("/listarSecao")
	public String listarSecao(Model model){
		List<Secao> secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		
		return "secao/listarSecao";
	}
	
	@RequestMapping("/apagarSecao")
	public String apagarSecao(Long id){
		this.sDAO.apagar(id);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/alterarSecaoFormulario")
	public String alterarSecaoFormulario(Long id, Model model){
		Secao s = this.sDAO.recuperar(id);
		model.addAttribute("secao", s);
		return "secao/alterarSecaoFormulario";
	}
	
	@RequestMapping("/alterarSecao")
	public String alterarSecao(Secao secao){
		this.sDAO.alterar(secao);
		return "redirect:listarSecao";
	}

}
