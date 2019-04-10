package br.unisul.pweb.jlc.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.jlc.domain.Competicao;
import br.unisul.pweb.jlc.dtos.CompeticaoDTO;
import br.unisul.pweb.jlc.services.CompeticaoServices;

@RestController
@RequestMapping(value = "/competicoes")
public class CompeticaoResource {

	@Autowired
	private CompeticaoServices service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Competicao> find(@PathVariable Integer id) {
		Competicao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}


	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Competicao obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getCod()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CompeticaoDTO>> findAll() {
		List<Competicao> lista = service.findAll(); 
		List<CompeticaoDTO> listaDTO = new ArrayList<CompeticaoDTO>();
		for (Competicao c : lista) {
			listaDTO.add(new CompeticaoDTO(c));
		}
		
		return ResponseEntity.ok().body(listaDTO);
	}

}
