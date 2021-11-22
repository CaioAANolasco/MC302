import java.util.ArrayList; 

public class RepositorioDeCursos { //inicio da classe RepositorioDeCursos
		
	private static ArrayList < Curso > listaCursos = new ArrayList < Curso >(); //ArrayList estatico que guarda os cursos 
		
	public static Curso adicionarCurso (String nome, int idCurso) { //metodo estatico para criar um novo curso
		Curso novoCurso = new Curso (nome, idCurso); //instancia um objeto curso
		listaCursos.add(novoCurso); 
		return novoCurso; //adiciona curso na lista e retorna o curso criado
	} //metodo de criacao de Curso
		
	public static Curso removerCurso (String nomeCurso) { //remocao de curso
		Curso cursoTemp = buscaCurso(nomeCurso);
		if(cursoTemp != null) {
			for(Aluno alunoTemp : cursoTemp.getListaAlunos()) {
				alunoTemp.setCursoMatriculado(null); //troca o atributo Curso dos aluno do curso removido por um elemento null placeholder
			}
			
			listaCursos.remove(cursoTemp); //remove curso procurado
		}
			
		return cursoTemp;

	} //metodo para remocao de curso do catalago de cursos 
	
	public static Curso buscaCurso (String nome) { //polimorfismo da busca
		for(Curso cursoTemp : listaCursos) {
			if(cursoTemp.getNome().equalsIgnoreCase(nome)) {
				return cursoTemp;
			}
		}
		
		return null;
	} //metodo para buscar um curso na lista de cursos registrados, usando apenas o nome como parametro
	
	public static Curso buscaCurso (int idCurso) { //polimorfismo da busca
		for(Curso cursoTemp : listaCursos) {
			if(cursoTemp.getIdCurso() == idCurso) {
				return cursoTemp;
			}
		}
		
		return null;
	} //busca um curso, usando o id como parametro
	
	public static void imprimeCursos () {
		for(Curso cursoTemp: listaCursos) {
			cursoTemp.imprimeDadosCurso();
		}
		
		System.out.println();
	} //metodo de impressao do catalogo de cursos
} //fim da classe RepositorioDeCursos
