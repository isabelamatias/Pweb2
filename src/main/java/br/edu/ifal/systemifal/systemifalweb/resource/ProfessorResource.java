package br.edu.ifal.systemifal.systemifalweb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.systemifal.systemifalweb.Repositories.ProfessorRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Professor;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Professor p = new Professor("Leonardo Bruno","888.563.258-35");
		professorRepository.save(p);
		return "OK";
		
	}
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Professor buscar (@PathVariable("id") Integer id) {
		return professorRepository.getOne(id);
	}
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public List<Professor> listar(){
		return professorRepository.findAll();
	}
	
	
	
}
