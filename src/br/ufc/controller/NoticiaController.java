package br.ufc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class NoticiaController {
	
	@Autowired
	private NoticiaDAO nDAO;
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private SecaoDAO sDAO;

	public NoticiaController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		List<Secao> secoes = new ArrayList<>();
		secoes = this.sDAO.listar();
		model.addAttribute("secoes", secoes);
		return "noticia/inserirNoticiaFormulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(HttpSession session, Noticia noticia, Long idSecao, Long idUsuario){
		if(session != null && noticia.getTitulo() != null && noticia.getSubtitulo() != null
				&& noticia.getTexto()!= null){
			Secao s = this.sDAO.recuperar(idSecao);
			Usuario u = this.uDAO.recuperar(idUsuario);
			noticia.setSecao(s);
			noticia.setUsuario(u);
			
			this.nDAO.inserir(noticia);
			return "cadastroOK";
		}
		return "redirect:inserirNoticiaFormulario";
	}
	
	@RequestMapping("/listarNoticiaSecao")
	public String listarNoticiaSecao(Secao s, Model model){
		List<Noticia> noticias = this.nDAO.noticiaSecao(s.getSecId());
		model.addAttribute("noticias", noticias);
		return "noticia/listarNoticiaSecao";
	}
	
	@RequestMapping("/listarNoticia")
	public String listarNoticia(Model model){
		List<Noticia> noticias = this.nDAO.listar();
		model.addAttribute("noticias", noticias);
		return "redirect:/";
	}
	
	@RequestMapping("/lerNoticia")
	public String lerNoticia(Noticia n, Model model){
		Noticia noticia = this.nDAO.recuperar(n.getNotId());
		model.addAttribute("noticia", noticia);
		return "noticia/lerNoticia";
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long idNoticia, Long idUsuario, HttpSession session){
		Noticia n = this.nDAO.recuperar(idNoticia);
		Usuario jornalista = this.uDAO.recuperar(n.getUsuario().getUsuId());
		Usuario editor = (Usuario) session.getAttribute("editor");
		if(editor != null){
			this.nDAO.apagar(idNoticia);
			return "redirect:listarNoticia";
		}else if(idUsuario == jornalista.getUsuId()){
			this.nDAO.apagar(idNoticia);
			return "redirect:listarNoticia";
		}
		return "redirect:lerNoticia";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long idNoticia, Model model){
		Noticia n = this.nDAO.recuperar(idNoticia);
		model.addAttribute("noticia", n);
		return "noticia/alterarNoticiaFormulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia n, Long idUsuario){
		if(idUsuario == n.getAutId()){
			this.nDAO.alterar(n);
			return "redirect:lerNoticia";
		}
		return "redirect:alterarNoticiaFormulario";
	}

}
