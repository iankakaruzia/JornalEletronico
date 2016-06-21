package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="PAPEL")
public class Papel {
	
	@Id
	@Column(name="PAP_ID", nullable=false)
	private Long papId;
	
	@Column(name="PAPEL", nullable=false)
	private String papel; 
	
	//MAIS FRACO(PRODUCT)
	
	@ManyToMany(mappedBy="papeis", fetch=FetchType.EAGER)
	private List<Usuario> usuarios;

	public Papel() {
		// TODO Auto-generated constructor stub
	}

	public Long getPapId() {
		return papId;
	}

	public void setPapId(Long papId) {
		this.papId = papId;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Papel))
			return false;
		Papel ref = (Papel)obj;
		if(ref.getPapId() == this.papId)
			return true;
		return false;
	}

}
