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
		if(uri.endsWith("loginUsuarioFormulario") || uri.endsWith("/") || uri.endsWith("listarSecao")
				|| uri.endsWith("listarNoticiaSecao") || uri.endsWith("lerNoticia") || uri.endsWith("listarComentarios")
				|| uri.endsWith("listarClassificados") || uri.endsWith("verClassificado")
				|| uri.endsWith("loginUsuario")){
			return true;
		}
		if(request.getSession().getAttribute("editor")!=null && (uri.endsWith("inserirSecaoFormulario") 
				|| uri.endsWith("inserirJornalistaFormulario") || uri.endsWith("listarUsuario"))){
			return true;
		}
		if(request.getSession().getAttribute("jornalista")!=null && uri.endsWith("inserirNoticiaFormulario")){
			return true;
		}
		if(request.getSession().getAttribute("leitor")!=null && uri.endsWith("inserirClassificadoFormulario")){
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
