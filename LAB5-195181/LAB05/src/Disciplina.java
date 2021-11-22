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
	
	public boolean addAluno( Aluno novoAluno ) {
		if(listaAlunos.size() < 25) { //se tem espaco disponivel
			listaAlunos.add(novoAluno); //adiciona elemento a lista, simultaneamente com metodo de adicao de Aluno
			return true;
		}else {
			System.out.println("Disciplina " + id + " " + nome + " esta cheia");
			return false; //se nao tem espaco
		}
	} //metodo para adicionar objeto Aluno para lista de Disciplina
	
	public boolean removeAluno( Aluno alunoRemovido ) {
		boolean removido = listaAlunos.remove(alunoRemovido); 
		if(removido) { //se achou o aluno procurado
			System.out.println("Aluno" + alunoRemovido.getNome() + "removido");
			return true;
		}else {
			System.out.println("Aluno nao esta matriculado nesta disciplina");
			return false; //se nao achou aluno procurado
		}
	} //metodo para remover objeto Aluno da lista de Disciplina

	public void imprimeDados() {
		String resp = "\n" + this.nome + "(" + this.id + ")\n";
		String matricula;
		
		for ( int i = 0; i < listaAlunos.size(); i++) {
			matricula = listaAlunos.get(i).getCPF();
			if (i == 0) {
				resp += "[" + matricula;
			} else { 
				resp += ", " + matricula;
			}
		}
		resp += "]";
		
		System.out.println(resp);
	} //metodo para impressao de dados
	
} //fim da classe Disciplina