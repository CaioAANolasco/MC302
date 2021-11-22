import java.util.Arrays;

public class Disciplina {
	
	private String nomeDisciplina;
	private final int IDDisciplina;
	private int numAlunosMatriculados = 0;
	public static final int MAX_ALUNOS = 25;
	private int[] listaMatriculados; //atributos de Disciplina, incluindo nome, ID, numero de alunos matriculados, numero maximo de alunos,
	//e um vetor com o numero de matricula dos alunos
	
	public Disciplina (int IDrecebido, String nomeRecebido) {
		
		IDDisciplina = IDrecebido;
		nomeDisciplina = nomeRecebido;
		listaMatriculados = new int [ MAX_ALUNOS ];
		
	} //metodo construtor da classe Disciplina, criando um vetor de matriculas do tamanho do numero maximo de alunos por disciplina
	
	public int getIDDisciplina() {
		
		return IDDisciplina;
		
	} //metodo get para o ID da disciplina
	
	public void setNome (String nomeDisciplina) {
		
		this.nomeDisciplina = nomeDisciplina;
		
	} //metodo set para o nome da disciplina
	
	public String getNome() {
		
		return this.nomeDisciplina;
		
	} //metodo get para o nome da disciplina
	
	public void adicionarMatricula(int novaMatricula) {
		
		int jaMatriculado = Arrays.binarySearch(listaMatriculados, novaMatricula); //verifica se aluno ja esta matriculado
		
		if(jaMatriculado < 0) {	//se nao esta matriculado
			if(numAlunosMatriculados < MAX_ALUNOS) { //se disciplina nao esta cheia
				listaMatriculados[0] = novaMatricula; //adiciona numero de matricula no vetor
				numAlunosMatriculados++; //incrementa numero de alunos matriculados
				Arrays.sort(listaMatriculados); //reorganiza vetor de matriculas
			}else
				System.out.println("Disciplina cheia"); //se disciplina esta cheia
		}
	}
	
	public void removerMatricula(int matriculaRemovida) {
	
		int indiceRemovido = Arrays.binarySearch(listaMatriculados, matriculaRemovida); //busca binaria do elemento a ser removido
		
		if(indiceRemovido >= 0) { //se existe tal numero de matricula
			listaMatriculados[indiceRemovido] = 0;
			Arrays.sort(listaMatriculados);
			numAlunosMatriculados--; //zera o numero da matricula removido, reorganiza vetor e decrementa numero de alunos matriculados
		}
	}
	
	public void imprimirDisciplina() {
		
		int[] copiaLista = Arrays.copyOfRange(listaMatriculados, (MAX_ALUNOS - numAlunosMatriculados) , MAX_ALUNOS);
		//cria uma copia do vetor de alunos matriculados, sem zeros (espacos vazios)
		
		System.out.printf("%s (%s)\n", nomeDisciplina, IDDisciplina);
		System.out.println(Arrays.toString(copiaLista)); //imprime vetor copia sem zeros
	}
} //fim da classe Disciplina