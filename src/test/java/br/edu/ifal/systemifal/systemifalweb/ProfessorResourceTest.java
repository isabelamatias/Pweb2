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

import br.edu.ifal.systemifal.systemifalweb.Repositories.ProfessorRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Professor;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessorResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/api/professor";
	
	@Autowired
	private ProfessorRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp() {
		repositorio.deleteAll();
		
		repositorio.save(new Professor( "Rafaelly", "125.564.568-45"));
		repositorio.save(new Professor( "Tawane", "215.654.658-54"));
		repositorio.save(new Professor( "Ana", "152.546.588-15"));
		//repositorio.save(new Professor( "Isabella", "155.584.548-78"));
		
		restTemplate = new RestTemplate();
		
	}
	
	@Test
	public void deveFuncionarAListagemDeTodosOsProfessores() throws JsonParseException, JsonMappingException, IOException {
		String resposta = restTemplate.getForObject(BASE_PATH + "/listar", String.class);
		
		List<Professor> professores = MAPPER.readValue(resposta, MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Professor.class));
		
		int tamanhoDaListaDeProfessoreEsperado = 3;
		assertEquals(tamanhoDaListaDeProfessoreEsperado, professores.size());
		
	}
	
	@Test
	public void deveFuncionarACriacaoDeUmNovoProfessores() throws JsonParseException, JsonMappingException, IOException {

		Professor professor = new Professor ("Maria", "123.225.255.45");
		
		restTemplate.postForObject(BASE_PATH+"/salvar",professor, Professor.class);
		
		String resposta = restTemplate.getForObject(BASE_PATH+"/listar", String.class);
		
		List<Professor> professores = MAPPER.readValue(resposta, 
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Professor.class));
				
		assertEquals("Maria", professores.get(0).getNome());
}
}