package br.edu.ifal.systemifal.systemifalweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.systemifal.systemifalweb.Repositories.AlunoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Aluno;



@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Aluno> alunos = repositorio.findAll();
		
		model.addAttribute("alunosList", alunos);
		
		model.addAttribute("mensagem", "Lista de Alunos");
		
		
		return "aluno/list";
	}

}
