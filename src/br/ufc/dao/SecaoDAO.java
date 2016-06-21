package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;

@Repository
public class SecaoDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public SecaoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Secao secao){
		manager.persist(secao);
	}
	
	public void alterar(Secao secao){
		manager.merge(secao);
	}
	
	public List<Secao> listar(){
		String hql = "select s from SECAO as s";
		return manager.createQuery(hql, Secao.class).getResultList();
	}
	
	public void apagar(Long id){
		Secao ref = this.recuperar(id);
		manager.remove(ref);
	}
	
	public Secao recuperar(Long id){
		return manager.find(Secao.class, id);
	}
	
	public Long recuperar(String titulo){
		String hql = "select s from SECAO where titulo = :varTitulo";
		Query query = manager.createQuery(hql);
		List<Secao> secoes = query.setParameter("varTitulo", titulo).getResultList();
		if(secoes.size() != 0){
			Secao ref = secoes.get(0);
			return ref.getSecId();
		}
		return null;
	}

}
