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
	
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newAluno(ModelMap model) {
		
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("edit", false);
		
		return "aluno/form";	

	}
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String saveAluno(@Valid @ModelAttribute Aluno aluno, BindingResult result,
							ModelMap model) {
		
		System.out.println(aluno);
		
		if (result.hasErrors()) {
			return "aluno/form";
		}
		
		repositorio.saveAndFlush(aluno);
		
		model.addAttribute("mensagem", "Aluno " + aluno.getNome() + " registrado com sucesso");
		
		return "redirect:/aluno/list";
	}

	
	
	@RequestMapping(value = { "/edit-{id}-aluno" }, method = RequestMethod.GET)
	public String editAluno(@PathVariable("id") Integer id, ModelMap model) {
		Aluno aluno = repositorio.getOne(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("edit", true);
	
		return "aluno/form";
	}
	
	@RequestMapping(value = { "/edit-{id}-aluno" }, method = RequestMethod.POST)
	public String updateAluno(@Valid Aluno aluno, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "aluno/form";
		}
		
		repositorio.saveAndFlush(aluno);
		
		model.addAttribute("mensagem", "Aluno " + aluno.getNome() + " atualizado com sucesso");
		
		return "redirect:/aluno/list";
	}
	
	@RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
	public String deleteAluno(@RequestParam("alunoId") Integer id) {
		repositorio.deleteById(id);
		return "redirect:/aluno/list";
	}
	
	@RequestMapping(value = { "/aluno-disciplinas" }, method = RequestMethod.GET)
	public String alunoDisciplinas(@RequestParam("alunoId") Integer id, ModelMap model) {
		Aluno aluno = repositorio.getOne(id);
		
		List<Aluno> disciplinasAll = repositorio.findAll();
		
	
		model.addAttribute("aluno", aluno);
		
		model.addAttribute("disciplinasAll", disciplinasAll);
		
		return "aluno/aluno-disciplinas";
	}
	
	
	@RequestMapping(value="/addDisciplina")
	public String addDisciplina(@RequestParam("disciplinaId") Integer disciplinaId,
			@RequestParam("alunoId") Integer alunoId) {
		
		Aluno aluno = repositorio.getOne(alunoId);
		Aluno disciplina =  repositorio.getOne(disciplinaId);
		
		aluno.addDisciplina(disciplina);
		
		repositorio.saveAndFlush(aluno);
		repositorio.saveAndFlush(disciplina);
		
		return "redirect:/aluno/aluno-disciplinas?alunoId="+aluno.getId();
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
