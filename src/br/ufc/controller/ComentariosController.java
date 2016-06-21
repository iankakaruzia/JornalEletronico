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
		return "comentarios/inserirComentarioFormulario";
	}
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(HttpSession session, Comentarios c, Long idUsuario, Long idNoticia){
		if(session != null && c.getTexto()!= null){
			Usuario u = this.uDAO.recuperar(idUsuario);
			Noticia n = this.nDAO.recuperar(idNoticia);
			
			c.setNoticia(n);
			c.setUsuario(u);
			this.comDAO.inserir(c);
			return "cadastroOK";
		}
		return "redirect:inserirComentarioFormulario";
	}
	
	@RequestMapping("/listarComentarios")
	public String listarComentarios(Model model){
		List<Comentarios> comentarios = this.comDAO.listar();
		model.addAttribute("comentarios", comentarios);
		return "comentarios/listarComentarios";
	}
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Long idCom, Long idUsuario, HttpSession session){
		Comentarios c = this.comDAO.recuperar(idCom);
		Usuario leitor = this.uDAO.recuperar(c.getAutId());
		Usuario editor = (Usuario) session.getAttribute("editor");
		if(editor != null){
			this.comDAO.apagar(idCom);
			return "redirect:listarComentarios";
		}else if(idUsuario == leitor.getUsuId()){
			this.comDAO.apagar(idCom);
			return "redirect:listarComentarios";
		}
		return "redirect:listarComentarios";
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long idCom, Model model){
		Comentarios c = this.comDAO.recuperar(idCom);
		model.addAttribute("comentario", c);
		return "comentarios/alterarComentarioFormulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentarios c, Long idUsuario){
		if(idUsuario == c.getAutId()){
			this.comDAO.alterar(c);
			return "noticia/listarComentarios";
		}
		return "redirect:alterarComentarioFomrulario";
	}

}
