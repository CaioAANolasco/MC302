import java.util.ArrayList;

public class Professor extends Funcionario{ //inicio da classe Professor
	
	private ArrayList < Integer > disciplinasMinistradas = new ArrayList < Integer >(); //lista de IDs de disciplinas
	
	public Professor (String nome, String CPF, int matricula, double salario) { //metodo construtor de Professor
		super(nome, CPF, matricula, salario); //chama metodo construtor da superclasses Funcionario e Pessoa
		disciplinasMinistradas.add(84);
		disciplinasMinistradas.add(7);
		disciplinasMinistradas.add(26);
		disciplinasMinistradas.add(43);
	}
	
	public void imprimeDados() {
		String saida = "########## Professor\n";
		saida = saida + "Nome: " + getNome() + "\n";
		saida = saida + "CPF: " + getCPF() + "\n";
		saida = saida + "Salario: " + getSalario() + "\n";
		saida = saida + "Lista disciplinas: " + disciplinasMinistradas.toString() + "\n";
		System.out.println(saida);				
	} //metodo de impressao dos atributos de Professor
} //fim da classe Professor
