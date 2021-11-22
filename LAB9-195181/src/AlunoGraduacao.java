
public class AlunoGraduacao extends Aluno {
	
	public AlunoGraduacao(String nome, int matricula, String CPF, Curso cursoMatriculado) {
		super(nome, matricula, CPF, cursoMatriculado); //chamada para o construtor de Aluno
	} //construtor de AlunoGrad
	
	@Override
	public double calculaCoeficiente() {
		double notasTotal = 0;		
		for(Double d : this.getListaNotas()) {
			notasTotal += d;
		} //percorre lista de notas e soma o total
		
		return (notasTotal/getListaNotas().size());
	} //metodo para calculo do coeficiente de rendimento de um aluno

	@Override
	public void imprimeDados() {
		String saida = "\nAluno Graduacao\n";
    	
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "Matricula: " + getMatricula() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Curso: " + getCursoMatriculado().getNome() + "\n";
        saida = saida + "CR : " + getCoeficienteR() + "\n";
        
        System.out.println(saida);
        
    } //metodo de impressao de dados para um objeto AlunoGrad

	@Override
	public boolean verificaAprovado(double nota) {
		if(nota >= 5) {
			return true;
		}
		
		return false;
	} //metodo que verifica de nota eh maior ou igual a 5

}
