package br.edu.ifal.systemifal.systemifalweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.ifal.systemifal.systemifalweb.Repositories.CursoRepository;
import br.edu.ifal.systemifal.systemifalweb.modelo.Aluno;
import br.edu.ifal.systemifal.systemifalweb.modelo.Curso;
import br.edu.ifal.systemifal.systemifalweb.modelo.Disciplina;
import br.edu.ifal.systemifal.systemifalweb.modelo.Escola;
import br.edu.ifal.systemifal.systemifalweb.modelo.Nota;
import br.edu.ifal.systemifal.systemifalweb.modelo.Professor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemifalWebApplicationTests {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Test
	public void testInsertCurso() {
		Curso c = new Curso("2" , "Tec. de Informártica para Internet");  
		
		cursoRepository.save(c);
	}
	
	@Test
	public void testFindNota() {
		Nota n = new Nota(9,"Maria","Programação WEB2","10");
		
		cursoRepository.count();
	}
	
	@Test
	public void testFindDisciplina() {
		Disciplina d = new Disciplina("1","programação WEB2");
		
		cursoRepository.count();
	}
	
	@Test
	public void testFindAluno() {
		Aluno a = new Aluno ("3","12345678921", "Michele");
		
		cursoRepository.count();
	}
	
	@Test
	public void testFindProfessor() {
		Professor p = new Professor ("5","Leonardo", "12345678935");
		
		cursoRepository.count();
	}
	
	@Test
	public void testFindEscola() {
		Escola e= new Escola ("7","Marcela");
		
		cursoRepository.count();
	}
	
	
	

}
