
import java.util.ArrayList;

public class Aluno { //inicio da classe Aluno

	private String nome;
    private String CPF;
    private int creditosAtuais;
    private Curso cursoMatriculado;

    private ArrayList < Disciplina > listaDisciplinas; //lista de disciplinas que aluno esta matriculado
    //atributos de um objeto aluno
    
    public Aluno (String nome, String CPF, Curso cursoMatriculado) {
    	this.nome = nome;
    	this.CPF = CPF;
    	this.cursoMatriculado = cursoMatriculado; //atribui um curso ao aluno
    	this.creditosAtuais = 0;
    	cursoMatriculado.adicionaAluno(this); //adiciona aluno a lista de aluno do seu curso
    	
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
	
    public Curso getCursoMatriculado() {
		return cursoMatriculado;
	} //metodo get para atributo cursoMatriculado

	public void setCursoMatriculado(Curso cursoMatriculado) {
		this.cursoMatriculado = cursoMatriculado;
		if(cursoMatriculado != null)
			cursoMatriculado.adicionaAluno(this);
	} //metodo set para atributo cursoMatriculado
	
	public int getCreditosAtuais() {
		return this.creditosAtuais;
	} //metodo get para creditosAtuais
	
	public void adicionaCreditos(int quantiaCreditos) {
		this.creditosAtuais += quantiaCreditos;
	} //metodo para soma de creditos quando o aluno eh matriculado em um disciplina
	
	public void incluidDisciplinaLista (Disciplina disciplina) {
		listaDisciplinas.add(disciplina);
	}// metodo para adicionar nova disciplina a lista de disicplina	
	
	public void cancelarMatricula () { //metodo responsavel pelo cancelamento de matricula do aluno no curso
		cursoMatriculado.removeAluno(this.CPF); //removo aluno da lista de seu curso
		while(!listaDisciplinas.isEmpty()) {
			this.removerDisciplina(listaDisciplinas.get(0)); //removo o aluno de todas as suas disicplinas
		}
		
		System.out.println("\nMatricula do aluno " + CPF + " do curso " + cursoMatriculado.getNome() + 
				" cancelada\n");
	}
	
	public void removerDisciplina (Disciplina disciplinaRemovida) {
		boolean removido = disciplinaRemovida.removeAluno(this); //procura aluno no objeto disciplina
		if(removido) {
			listaDisciplinas.remove(disciplinaRemovida); // se encontrou, remove disciplina da lista
			creditosAtuais -= disciplinaRemovida.getCreditosDisc();
		}	
	} //metodo removeDisciplina
	
	public void imprimeDados() {
    	String saida = "##########\n";
    	
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Creditos: " + getCreditosAtuais() + "\n";
        saida = saida + "Curso: " + cursoMatriculado.getNome() + "\n";

        System.out.println(saida);
        
    } //metodo de impressao de dados para um objeto Aluno  
} //fim da classe Aluno
