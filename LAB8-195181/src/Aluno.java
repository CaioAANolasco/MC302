/*
 * Nome: Caio Augusto Alves Nolasco 
 * RA: 195181
 * 
 * 	Este laboratorio 8 tem como intuito exercitar os conceito de classes e metodos abstratos. As classes Aluno, Pessoa e Disciplina dos laboratorios
 * anteriores sao definidas como abstratas, e em suas subclasses sao implementados os metodos especificos das subclasses, como impressao individual
 * e calculo de CR. Tambem eh implementada a veficacao de aprovacao dos alunos em uma disciplina, sendo as diferencas entre as avaliacoes entres alunos
 * de pos graduaca e graduacao tratados por meio de abstracao. Sao tambem feitas mudancas na subclasse de ArrayList MeuArray, de laboratorios anteriores,
 * dando uma maior generalizacao a seus metodos.
 */

import java.util.ArrayList;	

public abstract class Aluno extends Pessoa { //inicio da classe Aluno

	private int matricula;
	protected double coeficienteR; //CR
	private ArrayList < Double > listaNotas = new ArrayList < Double >(); //notas das disciplinas
    private Curso cursoMatriculado;

    private ArrayList < Disciplina > listaDisciplinas;
    //atributos de um objeto aluno
    
    public Aluno (int matricula, String nome, String CPF, Curso cursoMatriculado) {
    	super(nome, CPF);
    	this.matricula = matricula;
    	this.cursoMatriculado = cursoMatriculado;
    	this.cursoMatriculado.adicionaAluno(this); //adiciona aluno a lista de aluno do seu curso
    	
    } //metodo construtor para objeto Aluno
	
    public Curso getCursoMatriculado() {
		return cursoMatriculado;
	} //metodo get para atributo cursoMatriculado

	public void setCursoMatriculado(Curso cursoMatriculado) {
		this.cursoMatriculado = cursoMatriculado;
		if(cursoMatriculado != null)
			cursoMatriculado.adicionaAluno(this);
	} //metodo set para atributo cursoMatriculado
	
	public void adicionaDisciplina (Disciplina novaDisciplina) {
		
		boolean espacoDisponivel = novaDisciplina.addAluno(this); //se disciplina nao esta cheia, chama metodo da classe Disciplina
		if(espacoDisponivel) {
			listaDisciplinas.add(novaDisciplina); //se tem espaco disponivel, adiciona tambem a disciplina em Aluno
		}
	}
	//metodo adicionaDisciplina
	
	public void cancelarMatricula () { //metodo responsavel pelo cancelamento de matricula do aluno no curso
		cursoMatriculado.removeAluno(this.getCPF()); //removo aluno da lista de seu curso
		while(!listaDisciplinas.isEmpty()) {
			this.removerDisciplina(listaDisciplinas.get(0)); //removo o aluno de todas as suas disicplinas
		}
		
		System.out.println("\nMatricula do aluno " + getCPF() + " do curso " + cursoMatriculado.getNome() + 
				" cancelada\n");
	} //metodo cancelarMatricula
	
	public void removerDisciplina (Disciplina disciplinaRemovida) {
		boolean removido = disciplinaRemovida.removeAluno(this); //procura aluno no objeto disciplina
		if(removido) {
			listaDisciplinas.remove(disciplinaRemovida); // se encontrou, remove disciplina da lista
		}	
	} //metodo removeDisciplina
	
	public boolean procurarDisciplina (Disciplina disciplinaBuscada) {
		for(Disciplina discTemp : listaDisciplinas) {
			if(discTemp.equals(disciplinaBuscada)) {
				return true;
			}
		}
		
		return false;
	} //metodo para procurar uma disciplina em que aluno esta matrilado
	
	public void adicionarNota (double nota) {
		if(nota < 10 && nota > 0) {
			listaNotas.add(nota);
		}
		
		else {
			System.out.println("Nota invalida");
		}
	} //metodo para adicionar uma nota a lista de notas
		
	public double getCoeficienteR() {
		coeficienteR = calculaCoeficiente();
		
		return coeficienteR;
	} //metodo getCoeficienteR
	
	public ArrayList < Double > getListaNotas(){
		return listaNotas;
	} //metodo get para lista de notas
	
	public int getMatricula() {
        return this.matricula;
    } //metodo get para atributo matricula
    
    public void setMatricula (int matricula) {
    	this.matricula = matricula;
    } //metodo set para matricula
	
	public abstract void imprimeDados();
	public abstract double calculaCoeficiente();
	public abstract boolean verificaAprovado(double nota); //metodos abstrator de Aluno
	
} //fim da classe Aluno
