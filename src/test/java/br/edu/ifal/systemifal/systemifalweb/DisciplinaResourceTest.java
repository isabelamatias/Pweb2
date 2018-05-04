package br.edu.ifal.systemifal.systemifalweb;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifal.systemifal.systemifalweb.Repositories.DisciplinaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Disciplina;



public class DisciplinaResourceTest {

final String BASE_PATH = "http://localhost:8080/api/disciplina";
	
	@Autowired
	private DisciplinaRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp() {
		repositorio.deleteAll();
		
		repositorio.save(new Disciplina("Gestão e Qualidade de Software"));
		repositorio.save(new Disciplina("Matemática"));
		repositorio.save(new Disciplina("Programação Web 2"));
		repositorio.save(new Disciplina("Programação Móvel"));
		
		restTemplate = new RestTemplate();
		
	}
	@Test
	public void deveFuncionarAListagemDeTodasAsDisciplinas() throws JsonParseException, JsonMappingException, IOException {
		String resposta = restTemplate.getForObject(BASE_PATH + "/listar", String.class);
		
		List<Disciplina> disciplinas = MAPPER.readValue(resposta, MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Disciplina.class));
		
		int tamanhoDaListaDeDisciplinasEsperada = 4;
		assertEquals(tamanhoDaListaDeDisciplinasEsperada, disciplinas.size());
		
	}

}
