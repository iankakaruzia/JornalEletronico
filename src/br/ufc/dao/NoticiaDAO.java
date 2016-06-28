package br.ufc.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;

@Repository
public class NoticiaDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public NoticiaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Noticia noticia){
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		f.format(date);
		
		noticia.setDataNoticia(date);
		
		manager.persist(noticia);
	}
	
	public void alterar(Noticia noticia){
		manager.merge(noticia);
	}
	
	public List<Noticia> listar(){
		String hql = "select n from NOTICIA as n order by notId desc";
		return manager.createQuery(hql, Noticia.class).getResultList();
	}
	
	public void apagar(Long id){
		Noticia ref = this.recuperar(id);
		manager.remove(ref);
	}
	
	public Noticia recuperar(Long id){
		return manager.find(Noticia.class, id);
	}
	
	public List<Noticia> noticiaSecao(Long idSecao){
		String hql = "select n from NOTICIA as n where sec_id=:varSecao order by notId desc";
		Query query = manager.createQuery(hql);
		List<Noticia> noticias = query.setParameter("varSecao", idSecao).getResultList();
		return noticias;
	}

}
