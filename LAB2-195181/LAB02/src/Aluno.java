
public class Aluno { //inicio da classe Aluno
	private int matricula;
    private String nome;
    private String CPF;
    private int curso;
    private int atividade; //atributos de um objeto aluno
    
    public static final int ATIVO = 1;
    public static final int INATIVO = 0;
    public static final int SUSPENSO = -1;      
    //variaveis finais que indicam o estado do aluno, podendo ele estar ativo, inativo ou suspenso
    
    public Aluno (int atividade, String nome, String CPF, int curso) {
    	this.atividade = atividade;
    	this.matricula = GeradorMatricula.gerarMatricula(); //chama metodo static da classe GeradorMatricula
    	this.nome = nome;
    	this.CPF = CPF;
    	this.curso = curso;
    } //metodo construtor para objeto Aluno

    public int getMatricula() {
        return this.matricula;
    } //metodo get para atributo matricula
    
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
    
    public void setAtividade(int atividade) {
    	if(atividade != ATIVO  && atividade != INATIVO && atividade != SUSPENSO) {
    		System.out.println("Estado inválido para aluno\n");
    	}else {
    		this.atividade = atividade;
    	}
    } //metodo set para atributo atividade, podendo ele estar ativo, inativo ou suspenso
    
    public void imprimeDados() {
    	String saida = "########## Aluno\n";
        saida = saida + "Matrícula: " + getMatricula() + "\n";
        saida = saida + "Nome: " + getNome() + "\n";
        saida = saida + "CPF: " + getCPF() + "\n";
        saida = saida + "Curso: " + getCurso() + "\n";
        
        if(atividade == ATIVO) {
        	saida = saida + "Aluno em atividade.\n";
        }else if(atividade == INATIVO) {
        	saida = saida + "Aluno inativo.\n";
        }else if(atividade == SUSPENSO) {
        	saida = saida + "Aluno suspenso.\n";
        }//adiciona a saida o estado em que aluno se encontra

        System.out.println(saida);
    } //metodo de impressao de dados para um objeto Aluno
    
} //fim da classe Aluno
