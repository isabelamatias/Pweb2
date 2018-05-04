package br.edu.ifal.systemifal.systemifalweb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.systemifal.systemifalweb.Repositories.CursoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;


@RestController
@RequestMapping("/api/curso")
public class CursoResource {
	

	@Autowired
	CursoRepository cursoRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Curso c = new Curso("Informática para Internet");
		cursoRepository.save(c);
		return "OK";
		
	}
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Curso buscar (@PathVariable("id") Integer id) {
		return cursoRepository.getOne(id);
	}
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}

}
