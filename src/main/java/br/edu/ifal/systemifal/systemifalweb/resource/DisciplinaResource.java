package br.edu.ifal.systemifal.systemifalweb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.systemifal.systemifalweb.Repositories.DisciplinaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Disciplina;


@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
		public String carregar() {
			Disciplina d = new Disciplina("Matemática");
			disciplinaRepository.save(d);
			return "OK";
			
		}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Disciplina buscar (@PathVariable("id") Integer id) {
		return disciplinaRepository.getOne(id);
	}
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public List<Disciplina> listar(){
		return disciplinaRepository.findAll();
	}
}
