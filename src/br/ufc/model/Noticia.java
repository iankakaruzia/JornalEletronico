package br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="NOTICIA")
public class Noticia {
	
	@Id
	@Column(name="NOT_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long notId;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="SUBTITULO", nullable=false)
	private String subtitulo;
	
	@Column(name="TEXTO", nullable=false)
	private String texto;
	
	@Column(name="AUT_ID", nullable=false, insertable=false, updatable=false)
	private Long autId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_NOTICIA", nullable=false)
	private Date dataNoticia;
	
	@Column(name="SEC_ID", nullable=false, insertable=false, updatable=false)
	private Long secId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="SEC_ID", referencedColumnName="SEC_ID")
	private Secao secao;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="AUT_ID", referencedColumnName="USU_ID")
	private Usuario usuario;
	
	@OneToMany(mappedBy="noticia", targetEntity=Comentarios.class, fetch=FetchType.EAGER)
	private List<Comentarios> comentarios;

	public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public Long getNotId() {
		return notId;
	}

	public void setNotId(Long notId) {
		this.notId = notId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getAutId() {
		return autId;
	}

	public void setAutId(Long autId) {
		this.autId = autId;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public Long getSecId() {
		return secId;
	}

	public void setSecId(Long secId) {
		this.secId = secId;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Noticia))
			return false;
		Noticia ref = (Noticia)obj;
		if(ref.getNotId() == this.notId)
			return true;
		return false;
	}

}
