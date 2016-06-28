package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ComentariosDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Comentarios;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ComentariosController {
	
	@Autowired
	private ComentariosDAO comDAO;
	
	@Autowired
	private NoticiaDAO nDAO;
	
	@Autowired
	private UsuarioDAO uDAO;

	public ComentariosController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/inserirComentarioFormulario")
	public String inserirComentarioFormulario(){
		return "redirect:lerNoticia";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(HttpSession session, Comentarios c, Long idUsuario, Long idNoticia){
		if(session != null && c.getTexto()!= null){
			Usuario u = this.uDAO.recuperar(idUsuario);
			Noticia n = this.nDAO.recuperar(idNoticia);
			
			c.setNoticia(n);
			c.setU(u);
			this.comDAO.inserir(c);
			return "redirect:lerNoticia?notId="+idNoticia+"";
		}
		return "redirect:lerNoticia?notId="+idNoticia+"";
	}
	
	@RequestMapping("/listarComentarios")
	public String listarComentarios(Long idNoticia, Model model){
		List<Comentarios> comentarios = this.comDAO.listar();
		model.addAttribute("comentarios", comentarios);
		return "redirect:lerNoticia?notId="+idNoticia+"";
	}
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long idCom){
		Comentarios c = this.comDAO.recuperar(idCom);
		this.comDAO.apagar(idCom);
		return "redirect:lerNoticia?notId="+c.getNotId()+"";
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long idCom, Model model){
		Comentarios c = this.comDAO.recuperar(idCom);
		model.addAttribute("comentario", c);
		return "comentarios/alterarComentarioFormulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentarios c){
		this.comDAO.alterar(c);
		return "redirect:lerNoticia?notId="+c.getNotId()+"";
	}

}
