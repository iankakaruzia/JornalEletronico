package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="SECAO")
public class Secao {
	
	@Id
	@Column(name="SEC_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long secId;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="DESCRICAO", nullable=false)
	private String descricao;
	
	@OneToMany(mappedBy="secao", targetEntity=Noticia.class, fetch=FetchType.EAGER)
	private List<Noticia> noticias;

	public Secao() {
		// TODO Auto-generated constructor stub
	}

	public Long getSecId() {
		return secId;
	}

	public void setSecId(Long secId) {
		this.secId = secId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Secao))
			return false;
		Secao ref = (Secao)obj;
		if(ref.getSecId() == this.secId)
			return true;
		return false;
	}

}
