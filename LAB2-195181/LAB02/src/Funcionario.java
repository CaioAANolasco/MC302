
public class Funcionario { //inicio da classe Funcionario
	private int matricula;
	private String nome;
	private String CPF; //atributos de um objeto Funcionario, privados
	
	public int getMatricula() {
		return this.matricula;
	} //metodo get para atributo matricula
	
	public String getNome() {
		return this.nome;
	} //metodo get para atributo nome
	
	public void setNome(String nome) {
		if (nome.length() < 3) {
			System.out.println("Nome inválido.\n");
		}
		else {
			this.nome = nome;
		}
	} //metodo set para atributo nome, com verificacao da validade dos dados de parametro
	
	public String getCPF() {
		return this.CPF;		
	} //metodo get para atributo CPF
	
	public void setCPF(String CPF) {
		if (CPF.length() != 11) {
			System.out.println("CPF inválido.\n");
		}else {
			this.CPF = CPF;
		}
	} //metodo set para atributo CPF, com verificacao da validade dos dados de parametro
	
	public Funcionario (String nome, String CPF) {
		this.matricula = GeradorMatricula.gerarMatricula();
		this.nome = nome;
		this.CPF = CPF;
	} //metodo construtor para Funcionario
	
	public void imprimeDados() {
		String saida = "########## Funcionario\n";
		saida = saida + "Matricula: " +  getMatricula() + "\n";
		saida = saida + "Nome: " + getNome() + "\n";
		saida = saida + "CPF: " + getCPF() + "\n";
		
		System.out.println(saida);				
	} //metodo de impressao dos atributos de Funcionario
} //fim da classe Funcionario
