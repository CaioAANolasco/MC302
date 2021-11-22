import mc302ef.GerenciadorAlunos;
import java.util.ArrayList;

public class Aluno { //inicio da classe Aluno

    private int curso;
	private String nome;
    private String CPF;
    private int anoIngresso;
    protected int anoPrazo;
    private ArrayList < Disciplina > listaDisciplinas;
    //atributos de um objeto aluno
    
    public Aluno (String nome, String CPF, int curso) {
    	this.nome = nome;
    	this.CPF = CPF;
    	this.curso = curso;
    	
    	this.anoIngresso = GerenciadorAlunos.getAnoIngressoRandom();
    	this.listaDisciplinas = new ArrayList < Disciplina > ();	
    } //metodo construtor para objeto Aluno
    
    public String getNome() {
		return this.nome;
	} //metodo get para atributo nome
    
    public void setNome(String nome) {
		if (nome.length() < 3) {
			System.out.println("Nome inválido.\n");
		}
		else {
			this.nome = nome;
		}
	} //metodo set para atributo nome, com verificacao da validade dos dados de parametro
    
    public String getCPF() {
		return this.CPF;		
	} //metodo get para atributo CPF
	
	public void setCPF(String CPF) {
		if (CPF.length() != 11) {
			System.out.println("CPF inválido.\n");
		}else {
			this.CPF = CPF;
		}
	} //metodo set para atributo CPF, com verificacao da validade dos dados de parametro
	
    public int getCurso() {
    	return this.curso;
    } //metodo get para atributo curso
    
    public void setCurso(int curso) {
    	if(curso <= 0) {
    		System.out.println("Curso inválido.\n");
    	}else {
    		this.curso = curso;
    	}
    } //metodo set para atributo curso, verificando a validade dos dados de parametro

	public int getAnoPrazo() {
		return anoPrazo;
	} //metodo get para atributo AnoPrazo

	public void setAnoPrazo(int anoPrazo) {
		this.anoPrazo = anoPrazo;
	} //metodo set para atributo AnoPrazo
	
	public int getAnoIngresso() {
		return this.anoIngresso;
	} //metodo get para atributo anoIngresso
	
	public void adicionaDisciplina (Disciplina novaDisciplina) {
		boolean espacoDisponivel = novaDisciplina.addAluno(this); //se disciplina nao esta cheia, chama metodo da classe Disciplina
		if(espacoDisponivel) {
			listaDisciplinas.add(novaDisciplina); //se tem espaco disponivel, adiciona tambem a disciplina em Aluno
		}
	} //metodo adicionaDisciplina
	
	public void removeDisciplina (Disciplina disciplinaRemovida) {
		boolean estaNaDisciplina = disciplinaRemovida.removeAluno(this); //procura aluno no objeto disciplina
		if(estaNaDisciplina) {
			listaDisciplinas.remove(disciplinaRemovida); // se encontrou, remove
		}
	} //metodo removeDisciplina
	
	public void imprimeDados() {
    	String saida = "\n########## ";
    	
    	if(this instanceof AlunoGraduacao) {
    		saida = saida + "Aluno Graduacao\n";
    	}else if(this instanceof AlunoMestrado) {
    		saida = saida + "Aluno Mestrado\n";
    	}else if(this instanceof AlunoDoutorado) {
    		saida = saida + "Aluno Doutorado\n";
    	}
    	
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Curso: " + getCurso() + "\n";
        saida = saida + "Ano de ingresso: " + getAnoIngresso() + "\n";
        saida = saida + "Ano prazo: " + getAnoPrazo() + "\n";

        System.out.println(saida);
        
    } //metodo de impressao de dados para um objeto Aluno
    
} //fim da classe Aluno
