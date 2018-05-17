package br.edu.ifal.systemifal.systemifalweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifal.systemifal.systemifalweb.Repositories.CursoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;


@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Curso> cursos = repositorio.findAll();
		
		model.addAttribute("cursoList", cursos);
		
		model.addAttribute("mensagem", "Lista de Cursos");
		
		
		return "curso/list";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newCurso(ModelMap model) {
		
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		model.addAttribute("edit", false);
		
		return "curso/form";	

	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveCurso(@Valid @ModelAttribute Curso curso, BindingResult result,
							ModelMap model) {
		
		System.out.println(curso);
		
		if (result.hasErrors()) {
			return "curso/form";
		}
		
		repositorio.saveAndFlush(curso);
		
		model.addAttribute("mensagem", "Curso " + curso.getNome() + " registrado com sucesso");
		
		return "redirect:/curso/list";
	}

}