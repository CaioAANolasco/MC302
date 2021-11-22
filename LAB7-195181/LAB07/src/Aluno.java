
import java.util.ArrayList;

public class Aluno extends Pessoa { //inicio da classe Aluno

	private double coeficienteR; //CR
	private ArrayList < Double > listaNotas = new ArrayList < Double >(); //notas das disciplinas
    private Curso cursoMatriculado;

    private ArrayList < Disciplina > listaDisciplinas; //lista de disciplinas que aluno esta matriculado
    //atributos de um objeto aluno
    
    public Aluno (int matricula, String nome, String CPF, Curso cursoMatriculado) {
    	super(matricula, nome, CPF);
    	this.cursoMatriculado = cursoMatriculado;
    	this.cursoMatriculado.adicionaAluno(this); //adiciona aluno a lista de aluno do seu curso
    	
    	this.listaDisciplinas = new ArrayList < Disciplina > ();	
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
	} //metodo adicionaDisciplina
	
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
	
	public double calculaCoeficiente() {
		double notasTotal = 0;		
		for(Double d : listaNotas) {
			notasTotal += d;
		} //percorre lista de notas e soma o total
		
		return (notasTotal/listaNotas.size());
	} //metodo para calculo do coeficiente de rendimento de um aluno
	
	public double getCoeficienteR() {
		coeficienteR = calculaCoeficiente();
		
		return coeficienteR;
	} //metodo getCoeficienteR
	
	public ArrayList < Double > getListaNotas(){
		return listaNotas;
	} //metodo get para lista de notas
	
	@Override
	public void imprimeDados() { //override de metodo de Pessoa
    	String saida = "##########\n Aluno";
    	
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Curso: " + cursoMatriculado.getNome() + "\n";
        saida = saida + "CR : " + getCoeficienteR() + "\n";
        
        System.out.println(saida);
        
    } //metodo de impressao de dados para um objeto Aluno  
} //fim da classe Aluno
