package br.unisul.pweb.jlc.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.unisul.pweb.jlc.domain.Atleta;



public class AtletaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	private String modalidade1;
	private String modalidade2;
	private String modalidade3;
	
	
	public AtletaDTO(Atleta a) {
		cod = a.getCod();
		nome = a.getNome();
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtletaDTO other = (AtletaDTO) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModalidade1() {
		return modalidade1;
	}
	public void setModalidade1(String modalidade1) {
		this.modalidade1 = modalidade1;
	}
	public String getModalidade2() {
		return modalidade2;
	}
	public void setModalidade2(String modalidade2) {
		this.modalidade2 = modalidade2;
	}
	public String getModalidade3() {
		return modalidade3;
	}
	public void setModalidade3(String modalidade3) {
		this.modalidade3 = modalidade3;
	}
	
	
	

}
