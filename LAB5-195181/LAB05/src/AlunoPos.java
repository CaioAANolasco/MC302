
public class AlunoPos extends Aluno { //subclasse AlunoPos
	
	protected boolean isInglesComprovado;
	protected boolean isExameQualificacaoAprovado; //booleanos que marcam se aluno eh qualificado e fluente em ingles

	public AlunoPos(String nome, String CPF, int curso) {
		super(nome, CPF, curso);
	} //metodo construtor para AlunoPos

} //fim da classe AlunoPos
 