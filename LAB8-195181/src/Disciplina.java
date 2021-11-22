import java.util.ArrayList;

public abstract class Disciplina { //inicio da classe Disciplina
	
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
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
	
	public boolean equals (Disciplina disciplinaComparada) { //inicio do metodo equals
		if(disciplinaComparada.getID() == this.id && disciplinaComparada.getNome().equalsIgnoreCase(this.nome)) {
			return true;
		} //compara duas disciplinas pelo nome e id
		
		return false;
	} //fim do metodo equals
	
	public void imprimeDados() {
		String resp = "\n" + this.nome + "(" + this.id + ")\n";
		String matricula;
		
		if(listaAlunos.size() == 0) {
			resp = resp + "Nenhum aluno matriculado na disciplina " + this.nome + "\n";
		}else {
			for ( int i = 0; i < listaAlunos.size(); i++) {
				matricula = listaAlunos.get(i).getCPF();
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

	
} //fim da classe Disciplina