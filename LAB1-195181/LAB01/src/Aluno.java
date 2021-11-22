
public class Aluno { //inicio da classe Aluno
	private int matricula;
    private String nome;
    private String CPF;
    private int curso; //atributos de um objeto Aluno

    public int getMatricula() {
        return this.matricula;
    } //metodo get para atributo matricula

    public void setMatricula(int matricula) {
        if (matricula > 0) {
            this.matricula = matricula;
        } else {
            System.out.println("Matrícula inválida.\n");
        }
    } //metodo set para atributo matricula, verificando a validade dos dados de parametro
    
    public String getNome() {
    	return this.nome;
    } //metodo get para atributo nome
    
    public void setNome(String nome) {
    	int tamanhoNome = nome.length();
    	if(tamanhoNome < 3) {
    		System.out.println("Nome inválido.\n");
    	}else {
    		this.nome = nome;
    	}
    } //metodo set para atributo nome, verificando a validade dos dados de parametro
    
    public String getCPF() {
    	return this.CPF;    	
    } //metodo get para atributo CPF
    
    public void setCPF(String CPF) {
    	int tamanhoCPF = CPF.length();
    	if(tamanhoCPF != 11) {
    		System.out.println("CPF inválido.\n");
    	}else {
    		this.CPF = CPF;
    	}
    } //metodo set para atributo CPF, verificando a validade dos dados de parametro
    
    public int getCurso() {
    	return this.curso;
    } //metodo get para atributo curso
    
    public void setCurso(int curso) {
    	if(curso <= 0) {
    		System.out.println("Curso inválido.\n");
    	}else {
    		this.curso = curso;
    	}
    } //metodo set para atributo curso, verificando a validade dos dados de parametro
    
    public Aluno (int matricula, String nome, String CPF, int curso) {
    	this.matricula = matricula;
    	this.nome = nome;
    	this.CPF = CPF;
    	this.curso = curso;
    } //metodo construtor para objeto Aluno
    
    public void imprimeDados() {
    	String saida = "########## Aluno\n";
        saida = saida + "Matrícula: " + getMatricula() + "\n";
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Curso: " + getCurso() + "\n";

        System.out.println(saida);
    } //metodo de impressao de dados para um objeto Aluno
} //fim da classe Aluno
