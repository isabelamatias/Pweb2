package br.edu.ifal.systemifal.systemifalweb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.systemifal.systemifalweb.Repositories.NotaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Nota;

@RestController
@RequestMapping("/api/nota")
public class NotaResource {
	
	@Autowired
	NotaRepository notaRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		//Nota n = new Nota("Roberta","Gestão e Qualidade de Software","7.00");
		//notaRepository.save(n);
		return "OK";
		
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public  Nota buscar (@PathVariable("id") Integer id) {
		return notaRepository.getOne(id);
	}
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public List<Nota> listar(){
		return notaRepository.findAll();
	}
	
	

	

	

}
