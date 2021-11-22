import java.util.ArrayList;

public class RepositorioDeCursos { //inicio da classe RepositorioDeCursos
		
	private static ArrayList < Curso > listaCursos = new ArrayList < Curso >(); //ArrayList estatico que guarda os cursos 
		
	public static Curso adicionarCurso (String nome, int idCurso, int creditos) { //metodo estatico para criar um novo curso
		Curso novoCurso = new Curso (nome, idCurso, creditos); //instancia um objeto curso
		listaCursos.add(novoCurso); 
		return novoCurso; //adiciona curso na lista e retorna o curso criado
	} //metodo de criacao de Curso
		
	public static Curso removerCurso (String nomeCurso) { //remocao de curso
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
	
	public static void imprimeCursos () {
		for(Curso cursoTemp: listaCursos) {
			cursoTemp.imprimeDadosCurso();
		}
		
		System.out.println();
	} //metodo de impressao do catalogo de cursos
} //fim da classe RepositorioDeCursos
