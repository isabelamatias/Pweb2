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

import br.edu.ifal.systemifal.systemifalweb.Repositories.NotaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;
import br.edu.ifal.systemifal.systemifalweb.modelo.Nota;


@Controller
@RequestMapping("/nota")
public class NotaController {
	
	@Autowired
	NotaRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Nota> notas = repositorio.findAll();
		
		model.addAttribute("notasList", notas);
		
		model.addAttribute("mensagem", "Lista de Notas");
		
		
		return "nota/list";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newNota(ModelMap model) {
		
		Nota nota = new Nota();
		model.addAttribute("nota", nota);
		model.addAttribute("edit", false);
		
		return "nota/form";	

	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveNota(@Valid @ModelAttribute Nota nota, BindingResult result,
							ModelMap model) {
		
		System.out.println(nota);
		
		if (result.hasErrors()) {
			return "nota/form";
		}
		
		repositorio.saveAndFlush(nota);
		
		model.addAttribute("mensagem", "Nota " + nota.getAluno() + " registrado com sucesso");
		
		return "redirect:/nota/list";
	}
	
	@RequestMapping(value = { "/edit-{id}-nota" }, method = RequestMethod.GET)
	public String editNota(@PathVariable("id") Integer id, ModelMap model) {
		Nota nota= repositorio.getOne(id);
		model.addAttribute("Nota", nota);
		model.addAttribute("edit", true);
	
		return "nota/form";
	}
	
	@RequestMapping(value = { "/edit-{id}-nota" }, method = RequestMethod.POST)
	public String updateNota(@Valid Nota nota, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "nota/form";
		}
		

		repositorio.saveAndFlush(nota);
		
		model.addAttribute("mensagem", "Nota " + nota.getAluno() + " atualizado com sucesso");
		
		return "redirect:/nota/list";
	}
	



}
