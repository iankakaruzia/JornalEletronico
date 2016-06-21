package br.ufc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import sun.misc.BASE64Encoder;

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private PapelDAO pDAO;

	public LoginController() {
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
	
	@RequestMapping("loginUsuarioFormulario")
	public String loginUsuarioFormulario(){
		return "usuario/loginUsuarioFormulario";
	}
	
	@RequestMapping("/loginUsuario")
	public String login(HttpSession session, Usuario usuario, String papel){
		Usuario ref = this.uDAO.recuperar(usuario.getLogin());
		String senhaC = this.criptografa(usuario.getSenha());
		Long idPapel = this.pDAO.recuperar(papel);
		Papel p = pDAO.recuperar(idPapel);
		
		if(ref != null){
			List<Papel> papeis = ref.getPapeis();
			//Leitor
			if(ref.getSenha().equals(senhaC) 
					&& papel.equals("Leitor")
					&& papeis.contains(p)){
				session.setAttribute("leitor", ref);
				return "home";
			}else if(ref.getSenha().equals(senhaC)
					&& papel.equals("Jornalista")
					&& papeis.contains(p)){ //Jornalista
				session.setAttribute("jornalista", ref);
				return "home";
			}else if(ref.getSenha().equals(senhaC) 
					&& papel.equals("Editor")
					&& papeis.contains(p)){ //Editor
				session.setAttribute("editor", ref);
				return "home";
			}
		}
		
		return "redirect:loginUsuarioFormulario";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
