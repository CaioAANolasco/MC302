import java.util.ArrayList;

@SuppressWarnings("serial")
public class MeuArray extends ArrayList < Pessoa > { //inicio da classe MeuArray

	public static void imprimeLista (ArrayList < Pessoa> listaPessoas) { //metodo de impressao
		for(Pessoa pessoaAtual : listaPessoas) { //percorre lista ligada
			pessoaAtual.imprimeDados(); //chama o metodo do objeto pessoa, sobre escrito
		}
	} //fim do metodo imprimeLista
			
} //fim de MeuArray
