
public class AlunoPos extends Aluno { //subclasse AlunoPos
	
	private Professor professorOrientador; //associacao com um objeto Professor
		
	public AlunoPos(int matricula, String nome, String CPF, Curso curso) {
		super(matricula, nome, CPF, curso);
	} //metodo construtor para AlunoPos
	
	public AlunoPos(int matricula, String nome, String CPF, Curso curso, Professor professorOrientador) {
		super(matricula, nome, CPF, curso);
		this.setProfessorOrientador(professorOrientador);
	} //metodo construtor alternativo sobrecarregado para AlunoPos

	public Professor getProfessorOrientador() {
		return professorOrientador;
	} //metodo get para atributo professor

	public void setProfessorOrientador(Professor professorOrientador) {
		this.professorOrientador = professorOrientador;
	} //metodo set para atributo professor
			
	@Override
	public double calculaCoeficiente() { //override do metodo de Aluno
		double notasTotal = 0;
		
		for(Double d : this.getListaNotas()) {
			if(d >= 8.5) {
				notasTotal += 4;
			}else if(d < 8.5 && d >= 7) {
				notasTotal += 3;
			}else if(d < 7 && d >= 5) {
				notasTotal += 2;
			}else {
				notasTotal += 1;
			} //procura o intervalo em que cada nota do aluno se encaixa e soma o valor
		}
		
		return (notasTotal/this.getListaNotas().size()); //retorna a divisao do total pelo tamanho da lista
	}
	
	@Override
	public void imprimeDados() { //override do metodo de Pessoa
    	String saida = "##########\n Aluno Pos";
    	
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Curso: " + getCursoMatriculado().getNome() + "\n";
        saida = saida + "CR : " + getCoeficienteR() + "\n";
        if(professorOrientador != null)
        	saida = saida + "Professor Orientador: " + professorOrientador.getNome() + "\n";
        
        System.out.println(saida);
        
    } //metodo de impressao de dados para um objeto Aluno  

	@Override
	public boolean verificaAprovado(double nota) {
		
		char notaChar = 0;
		
		if(nota >= 8.5 ) {
			notaChar = 'A';
		}else if(nota >= 7 && nota < 8.5) {
			notaChar = 'B';
		}else if(nota < 7 && nota >= 5) {
			notaChar = 'C';
		}else if(nota < 5) {
			notaChar = 'D';
		} //atribui caractere a nota do aluno
		
		if(notaChar == 'D') { //se nota eh D, reprovado
			return false;
		}
		
		return true;
	}


} //fim da classe AlunoPos
 