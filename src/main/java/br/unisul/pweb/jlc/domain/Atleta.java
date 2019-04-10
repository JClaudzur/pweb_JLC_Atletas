package br.unisul.pweb.jlc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Atleta implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod;
	private String nome;
	
	
	
	/*
	 * 
	 * Adicionando o algoritimo acima sera possivel fazer a conexao das tabelas, criando assim uma tabela de relação.
	 * Lembrando que o nome da lista declarada logo abaixo deve estar com o mesmo nome na classe Competicao.
	 */
	
	@ManyToMany
	@JoinTable(name = "ATLETA_COMPETICAO",
		joinColumns = @JoinColumn(name = "atleta_id"),
		inverseJoinColumns = @JoinColumn(name = "competicao_id")
	)
	private List<Competicao> competicao = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="MODALIDADES")
	private Set<String> modalidades = new HashSet<>();

	public Atleta() {
		
	}
	
	public Atleta(Integer cod, String nome) {
		super();
		this.cod = cod;
		this.nome = nome;
		
	}
	
	public List<Competicao> getCompeticao() {
		return competicao;
	}

	public void setCompeticao(List<Competicao> competicao) {
		this.competicao = competicao;
	}

	public Set<String> getModalidades() {
		return modalidades;
	}

	public void setModalidades(Set<String> modalidades) {
		this.modalidades = modalidades;
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
		Atleta other = (Atleta) obj;
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
	
	
}
