package br.unisul.pweb.jlc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.jlc.domain.Atleta;
import br.unisul.pweb.jlc.domain.Competicao;
import br.unisul.pweb.jlc.dtos.AtletaDTO;
import br.unisul.pweb.jlc.repository.AtletaRepository;

@Service
public class AtletaServices {
		
	@Autowired
	private AtletaRepository rep;

	public List<Atleta> findAll(){
		return rep.findAll();
	}
	
	public Atleta find(Integer cod) {
		Optional<Atleta> obj = rep.findById(cod);
		return obj.orElse(null);
	}
	
	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}
	
	public Atleta fromDTO(AtletaDTO objDto) {
		Atleta atl = new Atleta(null, objDto.getNome());
		Competicao comp = new Competicao(objDto.getCod(), null, null);
		atl.getCompeticao().add(comp);
		atl.getModalidades().add(objDto.getModalidade());
		return atl;
	}
	
	
	public Atleta insert(Atleta obj) {
		obj.setCod(null);
		obj = rep.save(obj);
		return obj;
	}
}
