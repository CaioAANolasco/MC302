
public class AlunoGrad extends Aluno {
	
	public AlunoGrad(int matricula, String nome, String CPF, Curso cursoMatriculado) {
		super(matricula, nome, CPF, cursoMatriculado); //chamada para o construtor de Aluno
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
		String saida = "##########\n Aluno Graduacao";
    	
        saida = saida + "Nome: " + getNome() + "\n";
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
