package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="CLASSIFICADOS")
public class Classificados {
	
	@Id
	@Column(name="CLA_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long claId;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="TEXTO", nullable=false)
	private String texto;
	
	@Column(name="PRECO", nullable=false)
	private float preco;
	
	@Column(name="TELEFONE", nullable=false)
	private String telefone;
	
	@Column(name="MELHOR_OFERTA")
	private float melhor_oferta;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_OFERTA", nullable=false)
	private Date dataOferta;
	
	@Column(name="AUT_ID", insertable=false, updatable=false)
	private Long autId;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="AUT_ID", referencedColumnName="USU_ID")
	private Usuario usuario;

	public Classificados() {
		// TODO Auto-generated constructor stub
	}

	public Long getClaId() {
		return claId;
	}

	public void setClaId(Long claId) {
		this.claId = claId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getMelhor_oferta() {
		return melhor_oferta;
	}

	public void setMelhor_oferta(float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public Long getAutId() {
		return autId;
	}

	public void setAutId(Long autId) {
		this.autId = autId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Classificados))
			return false;
		Classificados ref = (Classificados)obj;
		if(ref.getClaId() == this.claId)
			return true;
		return false;
	}

}
