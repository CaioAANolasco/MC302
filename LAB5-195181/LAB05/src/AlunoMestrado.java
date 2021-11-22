
public class AlunoMestrado extends AlunoPos { //inicio da classe AlunoMestrado 
	
	private static int numAnosIntegralizacaoMestrado = 3; //atributo static para numero de ano para o prazo de conclusao
	
	public AlunoMestrado(String nome, String CPF, int curso) {
		super(nome, CPF, curso);
		this.calculaAnoMaxIntegralizacaoMestrado();
	} //metodo construtor
	
	public void setIsInglesComprovadoMestrado(boolean inglesComprovado) {
		this.isInglesComprovado = inglesComprovado;
	} //metodo set para InglesComprovado
	
	public void setIsExameQualificacaoAprovadoMestrado(boolean aprovado) {
		this.isExameQualificacaoAprovado = aprovado;
	} //metodo set para QualificacaoAprovado
	
	public void calculaAnoMaxIntegralizacaoMestrado() {
		this.anoPrazo = this.getAnoIngresso() + numAnosIntegralizacaoMestrado;
	} //metodo para o calculo do prazo de conclusao

} //fim da classe AlunoMestrado
