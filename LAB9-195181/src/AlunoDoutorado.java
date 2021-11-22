
public class AlunoDoutorado extends AlunoPos { //inicio da classe AlunoDoutorado

	private static int numAnosIntegralizacaoDoutorado = 6; //atributo static para numero de ano para o prazo de conclusao
	
	public AlunoDoutorado(String nome, int matricula, String CPF, Curso curso) {
		super(nome, matricula, CPF, curso);
		this.calculaAnoMaxIntegralizacaoDoutorado();
	} //metodo construtor para AlunoDoutorado
	
	public void setIsInglesComprovadoDoutorado(boolean inglesComprovado) {
		this.inglesComprovado = inglesComprovado;
	} //metodo set para InglesComprovado
	
	public void setIsExameQualificacaoAprovadoDoutorado(boolean aprovado) {
		this.exameQualificacaoAprovado = aprovado;
	} //metodo set QualificacaoAprovado
	
	public void calculaAnoMaxIntegralizacaoDoutorado() {
		this.setAnoPrazo(this.getAnoIngresso() + numAnosIntegralizacaoDoutorado);
	} //metodo para calculo do prazo de conclusao

} //fim da classe AlunoDoutorado
