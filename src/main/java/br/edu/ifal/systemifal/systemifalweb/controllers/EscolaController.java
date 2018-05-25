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

import br.edu.ifal.systemifal.systemifalweb.Repositories.EscolaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;
import br.edu.ifal.systemifal.systemifalweb.modelo.Escola;


@Controller
@RequestMapping("/escola")
public class EscolaController {
	
	@Autowired
	EscolaRepository repositorio;
	
	@RequestMapping(value= "/list", method=RequestMethod.GET)
	public String listar(ModelMap model) {
		
		List<Escola> escolas = repositorio.findAll();
		
		model.addAttribute("escolasList", escolas);
		
		model.addAttribute("mensagem", "Lista de Escolas");
		
		
		return "escola/list";
	}
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEscola(ModelMap model) {
		
		Escola escola = new Escola();
		model.addAttribute("escola", escola);
		model.addAttribute("edit", false);
		
		return "escola/form";	

	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveEscola(@Valid @ModelAttribute Escola escola, BindingResult result,
							ModelMap model) {
		
		System.out.println(escola);
		
		if (result.hasErrors()) {
			return "escola/form";
		}
		
		repositorio.saveAndFlush(escola);
		
		model.addAttribute("mensagem", "Escola " + escola.getNome() + " registrado com sucesso");
		
		return "redirect:/escola/list";
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteEscola(@RequestParam("escolaId") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/escola/list";
	}

	@RequestMapping(value = { "/edit-{id}-escola" }, method = RequestMethod.GET)
	public String editEscola(@PathVariable("id") Integer id, ModelMap model) {
		Escola escola= repositorio.getOne(id);
		model.addAttribute("escola", escola);
		model.addAttribute("edit", true);
	
		return "escola/form";
	}
	
	@RequestMapping(value = { "/edit-{id}-escola" }, method = RequestMethod.POST)
	public String updateEscola(@Valid Escola escola, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "escola/form";
		}
		

		repositorio.saveAndFlush(escola);
		
		model.addAttribute("mensagem", "Escola " + escola.getNome() + " atualizado com sucesso");
		
		return "redirect:/escola/list";
	}
	

}