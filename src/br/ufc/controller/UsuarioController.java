package br.ufc.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.util.FileUtil;
import sun.misc.BASE64Encoder;

@Transactional
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO uDAO;
	
	@Autowired
	private PapelDAO pDAO;
	
	@Autowired
	private ServletContext servletContext;

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
	public String inserirLeitor(Usuario u, @RequestParam(value="image", required=false) MultipartFile image){
		String senhaC = criptografa(u.getSenha());
		u.setSenha(senhaC);
		
		Long idLeitor = pDAO.recuperar("Leitor");
		
		if(image!=null && !image.isEmpty()){
			String path = servletContext.getRealPath("/")+"resources/images/"+u.getLogin()+".jpg";
			FileUtil.saveFile(path, image);
		}
				
		this.uDAO.inserir(u, idLeitor);
		
		return "home";
	}
	
	@RequestMapping("/inserirJornalistaFormulario")
	public String inserirJornalistaFormulario(){
		return "usuario/inserirJornalistaFormulario";
	}
	
	@RequestMapping("/inserirJornalista")
	public String inserirJornalista(Usuario u, @RequestParam(value="image", required=false) 
			MultipartFile image){
		String senhaC = criptografa(u.getSenha());
		u.setSenha(senhaC);
		
		Long idJornalista = pDAO.recuperar("Jornalista");
		
		if(image!=null && !image.isEmpty()){
			String path = servletContext.getRealPath("/")+"resources/images/"+u.getLogin()+".jpg";
			FileUtil.saveFile(path, image);
		}
				
		this.uDAO.inserir(u, idJornalista);
		
		return "home";
	}
	
	@RequestMapping("/listarUsuario")
	public String listarUsuario(Model model){
		List<Usuario> usuarios = this.uDAO.listar();
		model.addAttribute("usuarios", usuarios);
		
		return "usuario/listarUsuario";
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
