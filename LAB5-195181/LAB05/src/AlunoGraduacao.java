
public class AlunoGraduacao extends Aluno{ //inicio da classe AlunoGraduacao
	
	private static int numAnosIntegralizacaoGraduacao = 7; //atributo static para numero de ano para o prazo de conclusao

	public AlunoGraduacao(String nome, String CPF, int curso) {
		
		super(nome, CPF, curso);
		this.calculaAnoMaxIntegralizacaoGraduacao();
		
	}//metodo construtor de AlunoGraduacao
	
	public void calculaAnoMaxIntegralizacaoGraduacao() {
		
		this.anoPrazo = this.getAnoIngresso() + numAnosIntegralizacaoGraduacao;
		
	} //metodo calculaAnoMaxIntegralizacaoGraduacao

	public void recalcularAnoPrazoGraduacaoGraducao(int novoPrazo) {
		
		this.anoPrazo = this.getAnoIngresso() + novoPrazo;
		
	} //metodo para recalculo do prazo se necessario
} //fim da classe AlunoGraduacao
