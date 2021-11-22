
public class Pessoa { //inicio da classe Pessoa
	
	private int matricula;
	private String nome;
    private String CPF; //atributos em comum de objetos Pessoa
    
    public Pessoa(int matricula, String nome, String CPF) { //metodo construtor de Pessoa
    	this.nome = nome;
    	this.CPF = CPF;
    	this.matricula = matricula;
    }
    
    
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
	
	public int getMatricula() {
        return this.matricula;
    } //metodo get para atributo matricula
    
    public void setMatricula (int matricula) {
    	this.matricula = matricula;
    } //metodo set para matricula
    
    public void imprimeDados() {} //metodo de sera sobre escrito pelas subclasses
} //fim da classe Pessoa
