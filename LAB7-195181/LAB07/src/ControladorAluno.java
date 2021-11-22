import java.util.ArrayList;

public class ControladorAluno { //inicio da classe ControladorAluno
	
	private static ArrayList < Aluno > listaAlunos = new ArrayList < Aluno >(); //lista de alunos registrados
	
	public static void adicionarAluno(Aluno novoAluno) {
		listaAlunos.add(novoAluno);
	} //metodo de adicao na lista de aluno
	
	public static Aluno removerAluno(String CPF) {
		Aluno alunoRemovido = buscaAluno(CPF);
		if(alunoRemovido != null) {
			listaAlunos.remove(alunoRemovido);
		}
		
		return alunoRemovido;
	} //metodo de remocao da lista de aluno
	
	public static Aluno buscaAluno (int matricula) { //polimorfismo da busca
		
		for(Aluno alunoTemp : listaAlunos) {
			if(alunoTemp.getMatricula() == matricula) {
				return alunoTemp;
			}
		}
		
		return null;
		
	} //metodo para busca de aluno, usando apenas matricula como parametro
	
	public static Aluno buscaAluno (String CPF) { //polimorfismo da busca
		for(Aluno alunoTemp : listaAlunos) { 
			if(alunoTemp.getCPF().equalsIgnoreCase(CPF)) {
				return alunoTemp;
			}
		}
		
		return null;
	} //metodo para busca de aluno, usando apenas o CPF como parametro
	
	public static Aluno buscaAluno (String CPF, Curso curso) { //polimorfismo da busca
		for(Aluno alunoTemp : listaAlunos) {
			if(curso.equals(alunoTemp.getCursoMatriculado()) && alunoTemp.getCPF().equalsIgnoreCase(CPF)){
				return alunoTemp;
			}
		}
		
		return null;
	} //metodo para busca de aluno, usando CPF e curso como parametros
	
	public static Aluno buscaAluno (String nome, Disciplina disciplina) { //polimorfismo da busca
		for(Aluno alunoTemp : listaAlunos) {
			if(alunoTemp.getNome().equalsIgnoreCase(nome) && alunoTemp.procurarDisciplina(disciplina)) {
				return alunoTemp;
			}
		}
		
		return null;
	} //metodo para busca de aluno, usando nome e disciplina como parametos

} //fim da classe ControladorAluno
