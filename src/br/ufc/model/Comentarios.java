package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="COMENTARIOS")
public class Comentarios {
	
	@Id
	@Column(name="COM_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long comId;
	
	@Column(name="NOT_ID", nullable=false, insertable=false, updatable=false)
	private Long notId;
	
	@Column(name="AUT_ID", nullable=false, insertable=false, updatable=false)
	private Long autId;
	
	@Column(name="TEXTO", nullable=false)
	private String texto;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="AUT_ID", referencedColumnName="USU_ID")
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="NOT_ID", referencedColumnName="NOT_ID")
	private Noticia noticia;

	public Comentarios() {
		// TODO Auto-generated constructor stub
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public Long getNotId() {
		return notId;
	}

	public void setNotId(Long notId) {
		this.notId = notId;
	}

	public Long getAutId() {
		return autId;
	}

	public void setAutId(Long autId) {
		this.autId = autId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Comentarios))
			return false;
		Comentarios ref = (Comentarios)obj;
		if(ref.getComId() == this.comId)
			return true;
		return false;
	}

}
