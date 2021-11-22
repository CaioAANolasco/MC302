
public abstract class Pessoa { //inicio da classe Pessoa
	
	private String nome;
    private String CPF; //atributos em comum de objetos Pessoa
    
    public Pessoa(String nome, String CPF) { //metodo construtor de Pessoa
    	this.nome = nome;
    	this.CPF = CPF;
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
	 
    public abstract void imprimeDados(); //metodo abstrato de sera sobre escrito pelas subclasses
} //fim da classe Pessoa
