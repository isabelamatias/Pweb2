package br.edu.ifal.systemifal.systemifalweb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ifal.systemifal.systemifalweb.Repositories.DisciplinaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;
import br.edu.ifal.systemifal.systemifalweb.modelo.Disciplina;



@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Disciplina> disciplinas = repositorio.findAll();
		
		model.addAttribute("disciplinasList", disciplinas);
		
		model.addAttribute("mensagem", "Lista de Disciplinas");
		
		
		return "disciplina/list";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newDisciplina(ModelMap model) {
		
		Disciplina disciplina = new Disciplina();
		model.addAttribute("disciplina", disciplina);
		model.addAttribute("edit", false);
		
		return "disciplina/form";	

	}
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveDisciplina(@Valid @ModelAttribute Disciplina disciplina, BindingResult result,
							ModelMap model) {
		
		System.out.println(disciplina);
		
		if (result.hasErrors()) {
			return "disciplina/form";
		}
		
		repositorio.saveAndFlush(disciplina);
		
		model.addAttribute("mensagem", "Disciplina " + disciplina.getNome() + " registrado com sucesso");
		
		return "redirect:/disciplina/list";
	}
	
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteDisciplina(@RequestParam("disciplinaId") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/disciplina/list";
	}

	@RequestMapping(value = { "/edit-{id}-disciplina" }, method = RequestMethod.GET)
	public String editDisciplina(@PathVariable("id") Integer id, ModelMap model) {
		Disciplina disciplina= repositorio.getOne(id);
		model.addAttribute("Disciplina", disciplina);
		model.addAttribute("edit", true);
	
		return "disciplina/form";
	}
	
	@RequestMapping(value = { "/edit-{id}-disciplina" }, method = RequestMethod.POST)
	public String updateDisciplina(@Valid Disciplina disciplina, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "disciplina/form";
		}
		

		repositorio.saveAndFlush(disciplina);
		
		model.addAttribute("mensagem", "Disciplina" + disciplina.getNome() + " atualizado com sucesso");
		
		return "redirect:/disciplina/list";
	}
	

	
}