import java.util.ArrayList;
	
	public class Curso{ //inicio da classe Curso
		
	private String nome;
	private int creditosMax;
	private int idCurso; //atributos de Curso
	private ArrayList < Disciplina > listaDisciplinas;
	private ArrayList < Aluno > listaAlunos; //lista de disciplinas e aluno associados ao curso
					
	public Curso (String nome, int idCurso, int creditosMax) {
		this.nome = nome;
		this.idCurso = idCurso;
		this.creditosMax = creditosMax;
		
		listaDisciplinas = new ArrayList < Disciplina >();
		listaAlunos = new ArrayList < Aluno >();
	} //metodo construtor de Curso
		
	public String getNome() {
		return nome;
	} //metodo get para atributo nome
	
	public int getCreditosMax() {
		return this.creditosMax;
	} //metodo get para atributo creditosMax
	
	public void setCreditosMax (int creditosMax) {
		this.creditosMax = creditosMax;
	} //metodo set para atributo creditosMax
	
	public ArrayList < Aluno > getListaAlunos(){
		return listaAlunos;
	} //metodo get para listaAlunos
		
	public void adicionaDisciplina (Disciplina novaDisciplina) {
		listaDisciplinas.add(novaDisciplina);
	} //metodo para adicionar elemento disciplina a lista de disciplinas
	
	public void adicionaAluno (Aluno novoAluno) {
		listaAlunos.add(novoAluno);
	} //metodo para adicionar elemento aluno a lista de alunos
	
	public Disciplina removeDisciplina (String nomeDisciplina) { //remove disciplina da lista
		for(Disciplina discTemp : listaDisciplinas) {
			if(discTemp.getNome().equalsIgnoreCase(nomeDisciplina)) { //percorre lista de acha a procura via seu nome
				listaDisciplinas.remove(discTemp); //remove
				return discTemp;
			}
		}
		
		System.out.println("Disciplina " + nomeDisciplina + " nao encontrada"); //se nao achou disciplina
		return null;
	} //metodo para remocao de disciplina de Curso
	
	public Aluno removeAluno (String CPF) { //remove aluno da lista
		for(Aluno alunoTemp : listaAlunos) {
			if(alunoTemp.getCPF().equalsIgnoreCase(CPF)) { //procura aluno em questao por seu CPF
				listaAlunos.remove(alunoTemp); //remove
				return alunoTemp;
			}
		}
		
		System.out.println("Aluno " + CPF + " nao encontrado"); //se nao achou aluno
		return null;
	} //metodo para remocao de Aluno de Curso
	
	public void imprimeDadosCurso() {
				
		String resp = "\n" + this.nome + " (" + this.idCurso + ")\n" + "Alunos Registrados: \n";
		String CPFAlunos;
		
		if(listaAlunos.size() == 0) {
			resp = resp + "Nenhum aluno matriculado no curso " + nome;
		} else {
			for ( int i = 0; i < listaAlunos.size(); i++) {
				CPFAlunos = listaAlunos.get(i).getCPF();
				if (i == 0) {
					resp += "[" + CPFAlunos;
				} else { 
					resp += ", " + CPFAlunos;
				}
			}
			
			resp = resp + "]";
		}
		
		resp += "\nDisciplinas Resgistradas: \n";
		String idDisc;
		
		if(listaDisciplinas.size() == 0) {
			resp = resp + "Nenhuma disciplina registrada no curso " + nome;
		} else {
			for ( int i = 0; i < listaDisciplinas.size(); i++) {
				idDisc = listaDisciplinas.get(i).getNome();
				if (i == 0) {
					resp += "[" + idDisc;
				} else { 
					resp += ", " + idDisc;
				}
			}
			
			resp = resp + "]";
		}

		System.out.println(resp);
	} //metodo para impressao de dados de um curso, imprimindo tambem os CPF dos alunos registrados e as disciplinas de um objeto Curso
}//fim da classe Curso
