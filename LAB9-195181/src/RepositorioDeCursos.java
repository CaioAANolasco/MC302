import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class RepositorioDeCursos implements Enumeration<Curso>{ //inicio da classe RepositorioDeCursos
		
	private  ArrayList < Curso > listaCursos = new ArrayList < Curso >(); //ArrayList estatico que guarda os cursos 
	private int contador = 0; //variavel contadora para percorrer a lista de cursos usando Enumeration 
	
	public void adicionarCurso (String nome, int idCurso, int creditos) { //metodo estatico para criar um novo curso
		Curso novoCurso = new Curso (nome, idCurso, creditos); //instancia um objeto curso
		listaCursos.add(novoCurso); 
	} //metodo de criacao de Curso
	
	public void adicionarCurso (Curso novoCurso) { //metodo estatico para criar um novo curso
		listaCursos.add(novoCurso); 
	} //metodo de criacao de Curso
		
	public Curso removerCurso (String nomeCurso) { //remocao de curso
		for(Curso cursoTemp : listaCursos) {
			if(cursoTemp.getNome().equalsIgnoreCase(nomeCurso)) { //procura o curso de acordo com seu nome
				for(Aluno alunoTemp : cursoTemp.getListaAlunos()) {
					alunoTemp.setCursoMatriculado(null); //troca o atributo Curso dos aluno do curso removido por um elemento null placeholder
				}
				listaCursos.remove(cursoTemp); //remove curso procurado
				return cursoTemp;
			}
		}
		
		System.out.println("Curso nao encontrado"); //se nao acha curso
		return null;
	} //metodo para remocao de curso do catalago de cursos 
	
	public void imprimeCursos () {
		for(Curso cursoTemp: listaCursos) {
			cursoTemp.imprimeDados();
		}
		
		System.out.println();
	} //metodo de impressao do catalogo de cursos

	@Override
	public boolean hasMoreElements() {
		if(contador < listaCursos.size()) {
			return true;
		}
		else {
			contador = 0;
			return false;
		}
	} //implementacao do metodo hasMoreElements de Enumeration

	@Override
	public Curso nextElement() {
		Curso cursoProx = listaCursos.get(contador);
		contador++;
		return cursoProx;
	} //implementacao do Metodo nextElement de Enumeration
	
	public void organizarCursos() {
		Collections.sort(listaCursos);
	} //organiza os cursos por ordem alfabetica

} //fim da classe RepositorioDeCursos
