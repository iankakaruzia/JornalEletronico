package br.ufc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import sun.misc.BASE64Encoder;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private PapelDAO pDAO;

	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	public String criptografa(String senha){
		try{
		 MessageDigest digest = MessageDigest.getInstance("MD5");
		               digest.update(senha.getBytes());
		 BASE64Encoder encoder = new BASE64Encoder();
		        return encoder.encode(digest.digest());
		}catch(NoSuchAlgorithmException ns){
			ns.printStackTrace();
		}
		return senha;
	}
	
	@RequestMapping("/inserirLeitorFormulario")
	public String inserirLeitorFormulario(){
		return "usuario/inserirLeitorFormulario";
	}
	
	@RequestMapping("/inserirLeitor")
	public String inserirLeitor(Usuario u){
		String senhaC = criptografa(u.getSenha());
		u.setSenha(senhaC);
		
		Long idLeitor = pDAO.recuperar("Leitor");
				
		this.uDAO.inserir(u, idLeitor);
		
		return "cadastroOK";
	}
	
	@RequestMapping("/inserirJornalistaFormulario")
	public String inserirJornalistaFormulario(){
		return "usuario/inserirJornalistaFormulario";
	}
	
	@RequestMapping("/inserirJornalista")
	public String inserirJornalista(Usuario u, HttpSession session){
		String senhaC = criptografa(u.getSenha());
		u.setSenha(senhaC);
		
		Long idJornalista = pDAO.recuperar("Jornalista");
				
		this.uDAO.inserir(u, idJornalista);
		
		return "cadastroOK";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		
		return "noticia/listarUsuario";
	}
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long idUsuario){
		this.uDAO.apagar(idUsuario);
		return "redirect:listarUsuario";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		Usuario u = this.uDAO.recuperar(id);
		model.addAttribute("usuario", u);
		return "usuario/alterarUsuarioFormulario";
	}
	
	public String alterarUsuario(Usuario usuario){
		Usuario ref = this.uDAO.recuperar(usuario.getUsuId());
		List<Papel> papeis = ref.getPapeis();
		usuario.setPapeis(papeis);
		this.uDAO.alterar(usuario);
		return "redirect:listarUsuario";
	}

}
