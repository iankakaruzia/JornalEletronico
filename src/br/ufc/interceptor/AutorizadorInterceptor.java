package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{

	public AutorizadorInterceptor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.endsWith("/") || uri.endsWith("loginUsuarioFormulario") || uri.endsWith("loginUsuario")
				|| uri.endsWith("listarSecao") || uri.endsWith("listarClassificados") 
				|| uri.endsWith("verClassificado") || uri.endsWith("inserirLeitorFormulario")
				|| uri.endsWith("listarNoticiaSecao") || uri.endsWith("lerNoticia")){
			return true;
		}
		if(request.getSession().getAttribute("leitor")!=null && (uri.endsWith("inserirClassificadoFormulario")
				|| uri.endsWith("alterarClassificadoFormulario"))){
			return true;
		}
		if(request.getSession().getAttribute("jornalista")!=null && (uri.endsWith("inserirNoticiaFormulario") 
				|| uri.endsWith("alterarNoticiaFormulario"))){
			return true;
		}
		if(request.getSession().getAttribute("editor")!=null && (uri.endsWith("inserirJornalistaFormulario") 
				|| uri.endsWith("inserirSecaoFormulario") || uri.endsWith("alterarSecaoFormulario")
				|| uri.endsWith("listarUsuario"))){
			return true;
		}
		if(uri.equals("/JornalEletronico/resources/css/estilos.css") || uri.contains("resources/images/")
				|| uri.equals("/JornalEletronico/resources/css/formularios.css")){
			return true;
		}
		response.sendRedirect("loginUsuarioFormulario");
		return false;
	}

}
