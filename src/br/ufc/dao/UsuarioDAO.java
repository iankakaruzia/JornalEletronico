package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Repository
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Usuario u, Long idPapel){
		Papel p = manager.find(Papel.class, idPapel);
		List<Papel> papeis = new ArrayList<>();
		papeis.add(p);
		
		u.setPapeis(papeis);
		
		manager.persist(u);
	}
	
	public void alterar(Usuario u){
		manager.merge(u);
	}
	
	public List<Usuario> listar(){
		String hql = "select u from USUARIO as u";
		return manager.createQuery(hql, Usuario.class).getResultList();
	}
	
	public void apagar(Long id){
		Usuario u = this.recuperar(id);
		manager.remove(u);
	}
	
	public Usuario recuperar(Long id){
		return manager.find(Usuario.class, id);
	}
	
	public Usuario recuperar(String login){
		String hql = "select u from USUARIO as u where u.login = :var_login";
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = query.setParameter("var_login", login).getResultList();
		if(usuarios.size()!=0){
			return usuarios.get(0);
		}
		return null;
	}

}
