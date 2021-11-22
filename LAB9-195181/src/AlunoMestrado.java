
public class AlunoMestrado extends AlunoPos { //inicio da classe AlunoMestrado 
	
	private static int numAnosIntegralizacaoMestrado = 3; //atributo static para numero de ano para o prazo de conclusao
	
	public AlunoMestrado(String nome, int matricula, String CPF, Curso curso) {
		super(nome, matricula, CPF, curso);
		this.calculaAnoMaxIntegralizacaoMestrado();
	} //metodo construtor
	
	public void setIsInglesComprovadoMestrado(boolean inglesComprovado) {
		this.inglesComprovado = inglesComprovado;
	} //metodo set para InglesComprovado
	
	public void setIsExameQualificacaoAprovadoMestrado(boolean aprovado) {
		this.exameQualificacaoAprovado = aprovado;
	} //metodo set para QualificacaoAprovado
	
	public void calculaAnoMaxIntegralizacaoMestrado() {
		this.setAnoPrazo(this.getAnoIngresso() + numAnosIntegralizacaoMestrado);
	} //metodo para o calculo do prazo de conclusao

} //fim da classe AlunoMestrado
