package br.unisul.pweb.jlc.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.pweb.jlc.domain.Atleta;
import br.unisul.pweb.jlc.dtos.AtletaDTO;
import br.unisul.pweb.jlc.services.AtletaServices;

@RestController
@RequestMapping(value = "/atletas")
public class AtletaResource {
	
	@Autowired
	private AtletaServices service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Atleta> find(@PathVariable Integer cod) {
		Atleta obj = service.find(cod);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AtletaDTO objDto) {
		Atleta obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getCod()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AtletaDTO>> findAll() {
		List<Atleta> lista = service.findAll(); 
		List<AtletaDTO> listaDTO = new ArrayList<AtletaDTO>();
		for (Atleta c : lista) {
			listaDTO.add(new AtletaDTO(c));
		}
		
		return ResponseEntity.ok().body(listaDTO);
	}
	

}
