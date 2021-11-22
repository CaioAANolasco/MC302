import java.util.ArrayList;
import java.util.Collections;

public abstract class MeuArray extends ArrayList < Pessoa > { //inicio da classe MeuArray

	/**
	 * 
	 */
	private static final long serialVersionUID = 9058384680119176513L;

	public void organizaLista() { //metodo de organizacao organizaLista
		//organiza lista ligada de pessoas por meio de bubble sort
		for(int i = 0; i < this.size() - 1; i++) { //percorre lista
			for(int j = 0; j < this.size()-i-1; j++) { //compara com os seguintes elementos da lista
				if(compare(this.get(j), this.get(j+1))) { //usa metodo abstrato compare
					swap(this, j, j+1); //realiza troca
				}
			}
		}
	} //fim do metodo organizaLista
	
	public void swap(ArrayList < Pessoa > listaPessoas, int p1, int p2) {
		Collections.swap(listaPessoas, p1, p2); //troca entre elementos do ArrayList
	} //metodo para troca entre elementos do ArrayList
	
	public void imprimeLista (ArrayList < Pessoa> listaPessoas) { //metodo de impressao
		for(Pessoa pessoaAtual : listaPessoas) { //percorre lista ligada
			pessoaAtual.imprimeDados();
		}
	} //fim do metodo imprimeLista
	
	public abstract boolean compare(Pessoa obj1, Pessoa obj2);
			
} //fim de MeuArray
