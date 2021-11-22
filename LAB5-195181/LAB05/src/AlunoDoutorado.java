
public class AlunoDoutorado extends AlunoPos { //inicio da classe AlunoDoutorado

	private static int numAnosIntegralizacaoDoutorado = 6; //atributo static para numero de ano para o prazo de conclusao
	
	public AlunoDoutorado(String nome, String CPF, int curso) {
		super(nome, CPF, curso);
		this.calculaAnoMaxIntegralizacaoDoutorado();
	} //metodo construtor para AlunoDoutorado
	
	public void setIsInglesComprovadoDoutorado(boolean inglesComprovado) {
		this.isInglesComprovado = inglesComprovado;
	} //metodo set para InglesComprovado
	
	public void setIsExameQualificacaoAprovadoDoutorado(boolean aprovado) {
		this.isExameQualificacaoAprovado = aprovado;
	} //metodo set QualificacaoAprovado
	
	public void calculaAnoMaxIntegralizacaoDoutorado() {
		this.anoPrazo = this.getAnoIngresso() + numAnosIntegralizacaoDoutorado;
	} //metodo para calculo do prazo de conclusao

} //fim da classe AlunoDoutorado
