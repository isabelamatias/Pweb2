package br.edu.ifal.systemifal.systemifalweb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.systemifal.systemifalweb.Repositories.AlunoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Aluno;


@RestController
@RequestMapping("/api/aluno")
public class AlunoResource {

	@Autowired
	AlunoRepository alunoRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Aluno a = new Aluno("Clara","123.255.888-29","123456");
		alunoRepository.save(a);
		return "OK";	
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Aluno buscar (@PathVariable("id") Integer id) {
		return alunoRepository.getOne(id);
	}
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	
	
	
	

}
