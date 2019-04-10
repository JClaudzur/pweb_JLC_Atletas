package br.unisul.pweb.jlc.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.unisul.pweb.jlc.domain.Competicao;

public class CompeticaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String descricao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String data;
	
	public CompeticaoDTO() {
		
	}

	public CompeticaoDTO(Competicao obj) {
		cod = obj.getCod();
		descricao = obj.getData();
		data = obj.getData();
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
		CompeticaoDTO other = (CompeticaoDTO) obj;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
	

}
