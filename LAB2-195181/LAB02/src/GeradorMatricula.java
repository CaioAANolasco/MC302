
public class GeradorMatricula {	//inicio da classe GeradorMatricula
	private static int nova_matricula = 0; //variavel estatica que guarda o valor atual que matricula esta atribuido
	
	public static int gerarMatricula() { //inicio do metodo gerarMatricula
		//o metodo eh definido como estatico porque sera chamado na instanciacao de aluno e funcionario, sem haver instancia GeradorMatricula
		nova_matricula++; //aumenta o valor de matricula, e a mudanca permanesce devido ao fato de ser variavel estatica
		
		return nova_matricula;	//retorno nova matricula	
	} //fim do metodo gerarMatricula
} //fim da classe GerardorMatricula
