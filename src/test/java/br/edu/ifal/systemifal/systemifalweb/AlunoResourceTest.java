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

import br.edu.ifal.systemifal.systemifalweb.Repositories.AlunoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Aluno;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlunoResourceTest {

final String BASE_PATH = "http://localhost:8080/api/aluno";
	
	@Autowired
	private AlunoRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp() {
		
		repositorio.deleteAll();
		
		repositorio.save(new Aluno("Joana Maria","123.234.346-56",12, "2015" ));
		repositorio.save(new Aluno("Claudia Lyra","345.567.432-34",18, "2016" ));
		repositorio.save(new Aluno("Roseane Melo","124.230.365-89",20, "2017"));
		repositorio.save(new Aluno("Juliana Santos","321.675.768-74",19, "2018"));
		
		restTemplate = new RestTemplate();
		
	}
	@Test
	public void deveFuncionarAListagemDeTodosOsAlunos() throws JsonParseException, JsonMappingException, IOException {
		String resposta = restTemplate.getForObject(BASE_PATH + "/listar", String.class);
		
		List<Aluno> alunos = MAPPER.readValue(resposta, MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Aluno.class));
		
		int tamanhoDaListaDeAlunosEsperado = 4;
		assertEquals(tamanhoDaListaDeAlunosEsperado, alunos.size());
		
	}

}

