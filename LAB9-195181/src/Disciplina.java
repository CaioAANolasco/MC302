import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public abstract class Disciplina implements Imprimivel, Comparable<Disciplina>, Enumeration < Aluno >{ //inicio da classe Disciplina
	
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	private int contador;
	
	protected ArrayList < Aluno > listaAlunos;
	private ArrayList < Double > listaNotas;//atributos de Disciplina, com lista de objetos Aluno
	
	public Disciplina(int id, String nome) {
		this.id = id;
		this.nome = nome;

		listaNotas = new ArrayList < Double >();
		listaAlunos = new ArrayList < Aluno >();
	} //metodo construtor de Disciplina
	
	public String getNome() {
		return this.nome;
	} //metodo get para atributo Nome
	
	public int getID () {
		return id;
	} //metodo get para atributo ID
	
	public void setNome(String nome) {
		if (nome.length() >= Disciplina.NOME_MIN_LEN) {
			this.nome = nome;
		} else {
			System.out.println("O nome informado possui menos de " + Disciplina.NOME_MIN_LEN + " caracteres.");
		}
	} //metodo set para atributo Nome
	
	public boolean checaCheia() { //checa se a disciplina esta cheia
		if(listaAlunos.size() == MAX_ALUNOS) {
			System.out.println("Disciplina " + nome + " esta cheia"); //se esta cheia
			return true;
		}else {
			return false; //se nao esta cheia
		}
	}
	
	public abstract boolean addAluno( Aluno novoAluno );
	//metodo para adicionar objeto Aluno para lista de Disciplina, abstrato reescrito nas subclasses de Disciplina
	
	public boolean removeAluno( Aluno alunoRemovido ) { //metodo para remocao de aluno
		boolean removido = listaAlunos.remove(alunoRemovido); //remove aluno de ArrayList
		if(removido) {
			return true; //se achou o aluno em questao
		}else {
			System.out.println("Aluno " + alunoRemovido.getNome() + " nao matriculado na disciplina " + nome);
			return false; //se nao achou o aluno buscado
		}
	} //metodo para remover objeto Aluno da lista de Disciplina
	
	public void imprimeDados() {
		String resp = "\n" + this.nome + "(" + this.id + ")\n";
		int matricula;
		
		if(listaAlunos.size() == 0) {
			resp = resp + "Nenhum aluno matriculado na disciplina " + this.nome + "\n";
		}else {
			for ( int i = 0; i < listaAlunos.size(); i++) {
				matricula = listaAlunos.get(i).getMatricula();
				if (i == 0) {
					resp += "[" + matricula;
				} else { 
					resp += ", " + matricula;
				}
			}
			resp += "]";
		}	
			
		System.out.println(resp);
	} //metodo para impressao de dados
	
	public void gerarNotas(){	
		for(int i = 0; i < listaAlunos.size(); i++) {
			double nota = listaNotas.set(i,(Math.random() * 10));
			listaAlunos.get(i).adicionarNota(nota);
		} //gera notas aleatoriamente com um numero de 0 a 10 dado pela classe Math
	}	
	
	public void verificarAprovadoDisciplina() {
		this.gerarNotas(); //gera as notas
		
		for(int i = 0; i < listaNotas.size(); i++) {
			if(listaAlunos.get(i).verificaAprovado(listaNotas.get(i))) {
				System.out.println("Aluno: " + listaAlunos.get(i).getNome() + " aprovado");
			}else {
				System.out.println("Aluno: " + listaAlunos.get(i).getNome() + " reprovado");
			} //invoca os metodos de AlunoGrad e AlunoPos para verificar a aprovacao
		}
	}

	@Override
	public boolean equals(Object d1) {
		if(this.nome.compareToIgnoreCase(((Disciplina) d1).getNome()) == 0) {
			return true;
		}else {
			return false;
		}
	} //override do metodo equals
	
	public int compareTo(Disciplina discComparada) {
		return this.nome.compareTo(discComparada.getNome());
	} //implementacao do metodo da interface Comparable

	@Override
	public boolean hasMoreElements() {
		if(contador < listaAlunos.size()) {
			return true;
		}
		else {
			contador = 0;
			return false;
		}
	} //implementacao do metodo hasMoreElements de Enumeration

	@Override
	public Aluno nextElement() {
		Aluno alunoProx = listaAlunos.get(contador);
		contador++;
		return alunoProx;
	} //implementacao do metodo nextElement de Enumeration
	
	public void ordenarAlunos() {
		Collections.sort(listaAlunos);
	} //ordenar a lista de Alunos por ordem de matricula pelo metodo de Collections
	
} //fim da classe Disciplina