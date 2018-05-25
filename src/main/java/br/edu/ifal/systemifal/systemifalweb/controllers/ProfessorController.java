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
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newProfessor(ModelMap model) {
		
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		model.addAttribute("edit", false);
		
		return "professor/form";	

	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveProfessor(@Valid @ModelAttribute Professor professor, BindingResult result,
							ModelMap model) {
		
		System.out.println(professor);
		
		if (result.hasErrors()) {
			return "professor/form";
		}
		
		repositorio.saveAndFlush(professor);
		
		model.addAttribute("mensagem", "Professor " + professor.getNome() + " registrado com sucesso");
		
		return "redirect:/curso/list";
	}
	
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteProfessor(@RequestParam("professorId") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/professor/list";
	}
	
	@RequestMapping(value = { "/edit-{id}-professor" }, method = RequestMethod.GET)
	public String editProfessor(@PathVariable("id") Integer id, ModelMap model) {
		Professor professor = repositorio.getOne(id);
		model.addAttribute("Professor", professor);
		model.addAttribute("edit", true);
	
		return "professor/form";
	}
	
	@RequestMapping(value = { "/edit-{id}-professor" }, method = RequestMethod.POST)
	public String updateProfessor(@Valid Professor professor, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "professor/form";
		}
		

		repositorio.saveAndFlush(professor);
		
		model.addAttribute("mensagem", "Professor " + professor.getNome() + " atualizado com sucesso");
		
		return "redirect:/professor/list";
	}
	


}
