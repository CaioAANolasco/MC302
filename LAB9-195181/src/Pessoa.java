
public abstract class Pessoa implements Imprimivel, Comparable<Pessoa>  { //inicio da classe Pessoa
	
	private String nome;
	private int matricula;
    private String CPF; //atributos em comum de objetos Pessoa
    
    public Pessoa(String nome, int matricula, String CPF) { //metodo construtor de Pessoa
    	this.nome = nome;
    	this.matricula = matricula;
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
    
    public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


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
    
    public boolean equals(Object p1) {
		if(this.matricula == ((Pessoa) p1).getMatricula()) {
			return true;
		}else {
			return false;
		}
	} //override do metodo equals de Object
	
	public int compareTo(Pessoa pessoaComparada) {
		if(this.matricula > pessoaComparada.getMatricula()) {
			return 1;
		}else if(this.matricula < pessoaComparada.getMatricula()) {
			return -1;
		}else {
			return 0;
		}
	} //implementacao do metodo compareTo da interface Comparable

} //fim da classe Pessoa
