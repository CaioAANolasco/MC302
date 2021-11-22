
public class Funcionario extends Pessoa { //inicio da classe Funcionario
	
	private double salario; //atributos de um objeto Funcionario, privados

	public Funcionario (String nome, String CPF, int matricula, double salario) {
		super(nome, CPF, matricula);
		this.salario = salario;
	} //metodo construtor para Funcionario
	
	public double getSalario() {
		return salario;
	} //metodo get para atributo salario

	public void setSalario(double salario) {
		this.salario = salario;
	} //metodo set para atributo salario
	
	public void imprimeDados() {
		String saida = "########## Funcionario\n";
		saida = saida + "Nome: " + getNome() + "\n";
		saida = saida + "CPF: " + getCPF() + "\n";
		saida = saida + "Salario: " + getSalario() + "\n";
		System.out.println(saida);				
	} //metodo de impressao dos atributos de Funcionario
} //fim da classe Funcionario
