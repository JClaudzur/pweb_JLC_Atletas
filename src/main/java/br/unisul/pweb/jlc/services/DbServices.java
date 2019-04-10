package br.unisul.pweb.jlc.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.jlc.domain.Atleta;
import br.unisul.pweb.jlc.domain.Competicao;
import br.unisul.pweb.jlc.repository.AtletaRepository;
import br.unisul.pweb.jlc.repository.CompeticaoRepository;

@Service
public class DbServices {
	
	@Autowired
	private AtletaRepository atlRepo;
	
	@Autowired
	private CompeticaoRepository compRepo;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Atleta a1 = new Atleta(null, "Julia");
		Atleta a2 = new Atleta(null, "Isa");
		Atleta a3 = new Atleta(null, "Chris");
		
		Competicao c1 = new Competicao(null, "Voltinha", "19/07/19");
		Competicao c2 = new Competicao(null, "Corrida Centenaria", "07/02/99");
		
		a1.getCompeticao().addAll(Arrays.asList(c1, c2));
		a2.getCompeticao().addAll(Arrays.asList(c1));
		a3.getCompeticao().addAll(Arrays.asList(c2, c1));
		c1.getAtletas().addAll(Arrays.asList(a1, a2));
		c2.getAtletas().addAll(Arrays.asList(a2, a3));
		
		compRepo.saveAll(Arrays.asList(c1,c2));
		atlRepo.saveAll(Arrays.asList(a1,a2,a3));
		
	}

}
