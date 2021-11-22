
public class Funcionario extends Pessoa { //inicio da classe Funcionario
	

	public Funcionario (String nome, String CPF) {
		super(nome, CPF);
	} //metodo construtor para Funcionario
	
	@Override
	public void imprimeDados() {
		String saida = "########## Funcionario\n";
		saida = saida + "Nome: " + getNome() + "\n";
		saida = saida + "CPF: " + getCPF() + "\n";
		
		System.out.println(saida);				
	} //metodo de impressao dos atributos de Funcionario
} //fim da classe Funcionario
