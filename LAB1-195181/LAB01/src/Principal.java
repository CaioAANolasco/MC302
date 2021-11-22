/* NOME: Caio Augusto Alves Nolasco
 * RA: 195181
 * 
 * O programa a seguir eh composto por tres classe: Aluno, Funcionario, e Principal. As classes
 * Aluno e Funcionario contem os atributos dos objetos instancias dessas classes, assim como metodos
 * "get", "set" e construtores e de impressao, realizando as operacoes desejadas sobre os objetos.
 * A classe Principal contem o metodo main, cria instancias de Aluno e Funcionario e chama
 * os metodos respectivos. 
 */


public class Principal { //inicio da classe Principal
	//clase Principal que ira coordenar os processos feitos sobre as classes Funcionario e Aluno
	public static void main(String[] args) { //inicio da main
		Funcionario func1 = new Funcionario(1, "Arthur", "51051051099"); //cria objeto funcionario func1
		Aluno aluno1 = new Aluno(500001, "joão", "11122233399", 40); //cria objeto aluno aluno1

		func1.imprimeDados(); //imprime func1 com os dados da funcao construtora
		func1.setMatricula(-2);
		func1.setNome("Ar");
		func1.setCPF("123"); //tenta atribuir novos valores a matricula, nome e CPF, mas sao todos invalidos
		System.out.println( "Funcionario modificado(?): ");
		func1.imprimeDados(); //imprime novamente os dados de func1

		aluno1.imprimeDados(); //imprime aluno1 com os dados da funcao construtora
		aluno1.setMatricula(-1);
		aluno1.setNome("J");
		aluno1.setCPF("12345"); 
		aluno1.setCurso(-3); //tenta atribuir dados invalidos a aluno1 (nao sao computados)
		System.out.println( "Aluno modificado(?): ");
		aluno1.imprimeDados(); //imprime dados de aluno1
	}//fim da main
	
}//fim de Principal
