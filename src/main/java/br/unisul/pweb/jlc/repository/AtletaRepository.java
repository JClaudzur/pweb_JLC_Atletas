package br.unisul.pweb.jlc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.jlc.domain.Atleta;


public interface AtletaRepository extends JpaRepository<Atleta, Integer>{
//	List<Atleta> findDistinctByNomeContainingAndatletaIn(
//			String nome,
//			List<Competicao> categorias
//	);

}
