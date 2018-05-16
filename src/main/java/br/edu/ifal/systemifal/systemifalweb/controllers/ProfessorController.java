package br.edu.ifal.systemifal.systemifalweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.systemifal.systemifalweb.Repositories.ProfessorRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Professor;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	ProfessorRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Professor> professores = repositorio.findAll();
		
		model.addAttribute("professoresList", professores);
		
		model.addAttribute("mensagem", "Lista de Professores");
		
		
		return "professor/list";
	}

}
