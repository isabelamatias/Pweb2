package br.edu.ifal.systemifal.systemifalweb;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifal.systemifal.systemifalweb.Repositories.CursoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CursoResourceTest {
	
final String BASE_PATH = "http://localhost:8080/api/curso";
	
	@Autowired
	private CursoRepository repositorio;  
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp() {
		repositorio.deleteAll();
		
		repositorio.save(new Curso("Ciências da Computação"));
		repositorio.save(new Curso("Engenharia Química"));
		repositorio.save(new Curso("Informática para Internet"));
		repositorio.save(new Curso("Educação Física"));
		
		restTemplate = new RestTemplate();
		
	}
	@Test
	public void deveFuncionarAListagemDeTodosOsCursos() throws JsonParseException, JsonMappingException, IOException {
		String resposta = restTemplate.getForObject(BASE_PATH + "/listar", String.class);
		
		List<Curso> cursos = MAPPER.readValue(resposta, MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Curso.class));
		
		int tamanhoDaListaDeCursoEsperado = 4;
		assertEquals(tamanhoDaListaDeCursoEsperado,cursos.size());
		
	}

}
