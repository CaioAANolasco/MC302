import java.util.ArrayList;

public class Disciplina { //inicio da classe Disciplina
	
	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;
	public final int id;
	private String nome;
	private ArrayList < Aluno > listaAlunos; //atributos de Disciplina, com lista de objetos Aluno
	
	public Disciplina(int id, String nome) {
		this.id = id;
		this.nome = nome;

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
	
	public boolean addAluno( Aluno novoAluno ) {
		if(listaAlunos.size() < 25) { //se tem espaco disponivel
			listaAlunos.add(novoAluno); //adiciona elemento a lista, simultaneamente com metodo de adicao de Aluno
			return true;
		}else {
			System.out.println("Disciplina " + id + " " + nome + " esta cheia");
			return false; //se nao tem espaco
		}
	} //metodo para adicionar objeto Aluno para lista de Disciplina
	
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
	
} //fim da classe Disciplina