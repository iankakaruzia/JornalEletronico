package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;

@Repository
public class PapelDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public PapelDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Papel papel){
		manager.persist(papel);
	}
	
	public void alterar(Papel papel){
		manager.merge(papel);
	}
	
	public List<Papel> listar(){
		String hql = "select p from PAPEL as p";
		return manager.createQuery(hql, Papel.class).getResultList();
	}
	
	public void apagar(Long id){
		Papel papel = this.recuperar(id);
		manager.remove(papel);
	}
	
	public Papel recuperar(Long id){
		return manager.find(Papel.class, id);
	}
	
	public Long recuperar(String papel){
		String hql = "select p from PAPEL as p where papel = :varPapel";
		Query query = manager.createQuery(hql);
		List<Papel> papeis = query.setParameter("varPapel", papel).getResultList();
		if(papeis.size() != 0){
			Papel ref =  papeis.get(0);
			return ref.getPapId();
		}
		return null;
	}

}
