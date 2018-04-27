package br.edu.ifal.systemifal.systemifalweb.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.systemifal.systemifalweb.Repositories.EscolaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Escola;

@RestController
@RequestMapping("/escola")
public class EscolaResource {

		@Autowired
		EscolaRepository escolaRepository;
		
		@RequestMapping(value="carregar", method=RequestMethod.GET)
		public String carregar() {
			Escola e = new Escola("IFAL-MCZ");
			escolaRepository.save(e);
			return "OK";
			
		}
		
		@RequestMapping(value="{id}", method=RequestMethod.GET)
		public Escola buscar (@PathVariable("id") Integer id) {
			return escolaRepository.getOne(id);
		}
		
		@RequestMapping(value="listar", method=RequestMethod.GET)
		public List<Escola> listar(){
			return escolaRepository.findAll();
		}
		
		

}