package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadosDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificados;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class ClassificadosController {
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private ClassificadosDAO claDAO;

	public ClassificadosController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(){
		return "classificados/inserirClassificadoFormulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(HttpSession session, Classificados cla, Long idLeitor){
		if(session != null && cla.getTelefone()!= null && cla.getTexto() != null
				&& cla.getTitulo() != null){
			Usuario u = this.uDAO.recuperar(idLeitor);
			cla.setUsuario(u);
			
			this.claDAO.inserir(cla);
			return "cadastroOK";
		}
		return "redirect:inserirClassificadoFormulario";
	}
	
	@RequestMapping("/listarClassificados")
	public String listarClassificados(Model model){
		List<Classificados> classificados = this.claDAO.listar();
		model.addAttribute("classificados", classificados);
		
		return "classificados/listarClassificados";
	}
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long idCla, Long idUsuario, HttpSession session){
		Classificados cla = this.claDAO.recuperar(idCla);
		Usuario leitor = this.uDAO.recuperar(cla.getAutId());
		Usuario editor = (Usuario) session.getAttribute("editor");
		if(editor != null){
			this.claDAO.apagar(idCla);
			return "redirect:listarClassificados";
		}else if(idUsuario == leitor.getUsuId()){
			this.claDAO.apagar(idCla);
			return "redirect:listarClassificados";
		}
		return "redirect:listarClassificados";
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long idCla, Model model){
		Classificados cla = this.claDAO.recuperar(idCla);
		model.addAttribute("classificado", cla);
		return "classificados/alterarClassificadoFormulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificados cla, Long idUsuario){
		if(idUsuario == cla.getAutId()){
			this.claDAO.alterar(cla);
			return "redirect:listarClassificados";
		}
		return "redirect:alterarClassificadoFormulario";
	}
	
	@RequestMapping("/verClassificado")
	public String verClassificado(Classificados c, Model model){
		Classificados cla = this.claDAO.recuperar(c.getClaId());
		model.addAttribute("classificados", cla);
		return "classificados/verClassificado";
	}
	
	@RequestMapping("/inserirOferta")
	public String inserirOferta(Classificados c, Model model){
		return "cadastroOK";
	}
	
	

}
