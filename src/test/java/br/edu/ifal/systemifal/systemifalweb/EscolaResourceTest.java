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

import br.edu.ifal.systemifal.systemifalweb.Repositories.EscolaRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Escola;


public class EscolaResourceTest {

final String BASE_PATH = "http://localhost:8080/api/escola";
	
	@Autowired
	private EscolaRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp() {
		repositorio.deleteAll();
		
		repositorio.save(new Escola( ));
		repositorio.save(new Escola( ));
		repositorio.save(new Escola());
		repositorio.save(new Escola());
		
		restTemplate = new RestTemplate();
		
	}
	@Test
	public void deveFuncionarAListagemDeTodasAsEscolas() throws JsonParseException, JsonMappingException, IOException {
		String resposta = restTemplate.getForObject(BASE_PATH + "/listar", String.class);
		
		List<Escola> escolas = MAPPER.readValue(resposta, MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Escola.class));
		
		int tamanhoDaListaDeEscolasEsperada = 4;
		assertEquals(tamanhoDaListaDeEscolasEsperada, escolas.size());
		
	}


}
