import java.util.ArrayList;

public class MeuArray extends ArrayList < Pessoa > { //inicio da classe MeuArray

	public static void organizaLista(ArrayList < Pessoa > listaPessoas) { //metodo de organizacao organizaLista
		//organiza lista ligada de pessoas por meio de bubble sort
		for(int i = 0; i < listaPessoas.size() - 1; i++) { //percorre lista
			for(int j = 0; j < listaPessoas.size()-i-1; j++) { //compara com os seguintes elementos da lista
				if((listaPessoas.get(j).getNome()).compareToIgnoreCase(listaPessoas.get(j+1).getNome()) > 0) { //usa metodo de String compareTo para verificar ordem
					Pessoa pessoaTrocada = listaPessoas.set(j+1, listaPessoas.get(j));
					listaPessoas.set(j, pessoaTrocada); //troca elementos de lugar quando necessario
				}
			}
		}
	} //fim do metodo organizaLista
	
	public static void imprimeLista (ArrayList < Pessoa> listaPessoas) { //metodo de impressao
		for(Pessoa pessoaAtual : listaPessoas) { //percorre lista ligada
			if (pessoaAtual instanceof Aluno) { //se objeto em questao eh Aluno
				((Aluno) pessoaAtual).imprimeDados(); //
			}else if(pessoaAtual instanceof Funcionario) { //se eh Funcionario
				((Funcionario) pessoaAtual).imprimeDados();
			}else { //se eh Professor	
				((Professor) pessoaAtual).imprimeDados();
			}
		}
	} //fim do metodo imprimeLista
			
} //fim de MeuArray
