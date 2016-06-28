package br.ufc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;
import br.ufc.util.FileUtil;

@Transactional
@Controller
public class NoticiaController {
	
	@Autowired
	private NoticiaDAO nDAO;
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private SecaoDAO sDAO;
	
	@Autowired
	private ServletContext servletContext;

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
	public String inserirNoticia(HttpSession session, Noticia noticia, Long idSecao, Long idUsuario,
			@RequestParam(value="image", required=false) MultipartFile image){
		if(session != null && noticia.getTitulo() != null && noticia.getSubtitulo() != null
				&& noticia.getTexto()!= null){
			Secao s = this.sDAO.recuperar(idSecao);
			Usuario u = this.uDAO.recuperar(idUsuario);
			noticia.setSecao(s);
			noticia.setU(u);
			
			if(image!=null && !image.isEmpty()){
				String path = servletContext.getRealPath("/") + "resources/images/" + noticia.getTitulo() + ".jpg";
				FileUtil.saveFile(path, image);
			}
			
			this.nDAO.inserir(noticia);
			return "redirect:inserirNoticiaFormulario";
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
		model.addAttribute("nots", noticias);
		return "home";
	}
	
	@RequestMapping("/lerNoticia")
	public String lerNoticia(Noticia n, Model model){
		Noticia noticia = this.nDAO.recuperar(n.getNotId());
		model.addAttribute("noticia", noticia);
		return "noticia/lerNoticia";
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Long idNoticia){
		this.nDAO.apagar(idNoticia);
		return "home";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long idNoticia, Model model){
		Noticia n = this.nDAO.recuperar(idNoticia);
		model.addAttribute("noticia", n);
		return "noticia/alterarNoticiaFormulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia n){
		this.nDAO.alterar(n);
		return "redirect:lerNoticia?notId=" + n.getNotId() + "";
		
	}

}
