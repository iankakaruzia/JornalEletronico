package br.ufc.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificados;

@Repository
public class ClassificadosDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public ClassificadosDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Classificados classificados){
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		f.format(date);
		
		classificados.setDataOferta(date);
		
		manager.persist(classificados);
	}
	
	public void alterar(Classificados classificados){
		manager.merge(classificados);
	}
	
	public List<Classificados> listar(){
		String hql = "select c from CLASSIFICADOS as c order by claId desc";
		return manager.createQuery(hql, Classificados.class).getResultList();
	}
	public void apagar(Long id){
		Classificados ref = this.recuperar(id);
		manager.remove(ref);
	}
	
	public Classificados recuperar(Long id){
		return manager.find(Classificados.class, id);
	}
	
	public float melhorOferta(){
		String hql = "select c from CLASSIFICADOS as c where c.melhor_oferta = (select max(d.melhor_oferta) from "
				+ "CLASSIFICADOS as d where c.claId = d.claId)";
		List<Classificados> classificados = manager.createQuery(hql, Classificados.class).getResultList();
		return classificados.get(0).getMelhor_oferta();
	}

}
