
public class Aluno extends Pessoa { //inicio da classe Aluno

    private int curso;
    private int atividade; //atributos de um objeto aluno
    
    public static final int ATIVO = 1;
    public static final int INATIVO = 0;
    public static final int SUSPENSO = -1;      
    //variaveis finais que indicam o estado do aluno, podendo ele estar ativo, inativo ou suspenso
    
    public Aluno (String nome, String CPF, int curso, int matricula, int atividade) {
    	super(nome, CPF, matricula); //chama metodo construtor de superclasse Pessoa
    	this.atividade = atividade;
    	this.curso = curso;
    } //metodo construtor para objeto Aluno

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
