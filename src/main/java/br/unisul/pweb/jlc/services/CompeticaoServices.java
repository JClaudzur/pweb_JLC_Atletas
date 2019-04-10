package br.unisul.pweb.jlc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.jlc.domain.Competicao;
import br.unisul.pweb.jlc.repository.CompeticaoRepository;

@Service
public class CompeticaoServices {
	
		@Autowired
		private CompeticaoRepository rep;
		
		public List<Competicao> findAll(){
			return rep.findAll();
		}

		public Competicao find(Integer cod) {
			Optional<Competicao> obj = rep.findById(cod);
			return obj.orElse(null);
		}
		
		public Competicao insert (Competicao obj) {
			obj.setCod(null);
			return rep.save(obj);
		}

	
		public void delete (Integer id) {
			find(id);
			rep.deleteById(id);
		}

}
