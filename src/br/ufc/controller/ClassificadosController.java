package br.ufc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
			cla.setU(u);
			
			this.claDAO.inserir(cla);
			return "redirect:listarClassificados";
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
	public String apagarClassificado(Long idCla){
		this.claDAO.apagar(idCla);
		return "redirect:listarClassificados";
	}
	
	@RequestMapping("/alterarClassificadoFormulario")
	public String alterarClassificadoFormulario(Long idCla, Model model){
		Classificados cla = this.claDAO.recuperar(idCla);
		model.addAttribute("classificado", cla);
		return "classificados/alterarClassificadoFormulario";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificados cla){
		this.claDAO.alterar(cla);
		return "redirect:listarClassificados";
	}
	
	@RequestMapping("/verClassificado")
	public String verClassificado(Classificados cla, Model model){
		Classificados cla2 = this.claDAO.recuperar(cla.getClaId());
		model.addAttribute("classificados", cla2);
		return "classificados/verClassificado";
	}
	
	@RequestMapping("/inserirOfertaFormulario")
	public String inserirOfertaFormulario(){
		return "redirect:verClassificado";
	}
	
	@RequestMapping("/inserirOferta")
	public String inserirOferta(Long idCla, Long idUsuario, float valor){
		Classificados c = this.claDAO.recuperar(idCla);
		if(valor > this.claDAO.melhorOferta()){
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			f.format(date);
			
			c.setDataOferta(date);
			c.setAutMelhorOferta(idUsuario);
			c.setMelhor_oferta(valor);
			return "redirect:verClassificado?claId=" + idCla + "";
		}
		return "redirect:listarClassificados";
	}
	
}
