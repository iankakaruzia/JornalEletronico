package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="USU_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long usuId;
	
	@Column(name="LOGIN", nullable=false, unique=true)
	private String login;
	
	@Column(name="SENHA", nullable=false)
	private String senha;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	//MAIS FORTE(ORDER)
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USUARIO_PAPEL", joinColumns=@JoinColumn(name="USU_ID", referencedColumnName="USU_ID"),
				inverseJoinColumns=@JoinColumn(name="PAP_ID", referencedColumnName="PAP_ID"))
	private List<Papel> papeis;
	
	@OneToMany(mappedBy="usuario", targetEntity=Noticia.class, fetch=FetchType.EAGER)
	private List<Noticia> noticias;
	
	@OneToMany(mappedBy="usuario", targetEntity=Comentarios.class, fetch=FetchType.EAGER)
	private List<Comentarios> comentarios;
	
	@OneToMany(mappedBy="usuario", targetEntity=Classificados.class, fetch=FetchType.EAGER)
	private List<Classificados> classificados;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}
	
	public List<Classificados> getClassificados() {
		return classificados;
	}

	public void setClassificados(List<Classificados> classificados) {
		this.classificados = classificados;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario))
			return false;
		Usuario ref = (Usuario)obj;
		if(ref.getUsuId() == this.usuId)
			return true;
		return false;
	}

}
