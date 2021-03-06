package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentarios;

@Repository
public class ComentariosDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public ComentariosDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Comentarios comentarios){
		manager.persist(comentarios);
	}
	
	public void alterar(Comentarios comentarios){
		manager.merge(comentarios);
	}
	
	public List<Comentarios> listar(){
		String hql = "select c from COMENTARIOS as c order by comId desc";
		return manager.createQuery(hql, Comentarios.class).getResultList();
	}
	
	public List<Comentarios> listarComentarioNoticia(Long id){
		String hql = "select c from COMENTARIOS as c where not_id=:varNoticia order by comId desc";
		Query query = manager.createQuery(hql);
		List<Comentarios> comentarios = query.setParameter("varNoticia", id).getResultList();
		return comentarios;
	}
	
	public void apagar(Long id){
		Comentarios ref = this.recuperar(id);
		manager.remove(ref);
	}
	
	public Comentarios recuperar(Long id){
		return manager.find(Comentarios.class, id);
	}

}
