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

import br.edu.ifal.systemifal.systemifalweb.Repositories.AssuntoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Assunto;



@Controller
@RequestMapping("/assunto")
public class AssuntoController {
	
	@Autowired
	AssuntoRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Assunto> assuntos = repositorio.findAll();
		
		model.addAttribute("assuntoList", assuntos);
		
		model.addAttribute("mensagem", "Lista de Assuntos");
		
		
		return "assunto/list";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newAssunto(ModelMap model) {
		
		Assunto assunto = new Assunto();
		model.addAttribute("assunto", assunto);
		model.addAttribute("edit", false);
		
		return "assunto/form";	

	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveCurso(@Valid @ModelAttribute Assunto assunto, BindingResult result,
							ModelMap model) {
		
		System.out.println(assunto);
		
		if (result.hasErrors()) {
			return "assunto/form";
		}
		
		repositorio.saveAndFlush(assunto);
		
		model.addAttribute("mensagem", "Assunto " + assunto.getNome() + " registrado com sucesso");
		
		return "redirect:/assunto/list";
	}

}