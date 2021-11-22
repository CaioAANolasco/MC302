/* NOME: Caio Augusto Alves Nolasco
 * RA: 195181
 * 
 * 	O programa a seguir eh composto por quatro classes: Aluno, Funcionario, Principal e GeradorMatricula. As classes
 * Aluno e Funcionario contem os atributos dos objetos instancias dessas classes, assim como metodos
 * "get", "set" e construtores e de impressao, realizando as operacoes desejadas sobre os objetos.
 * A classe Principal contem o metodo main, cria instancias de Aluno e Funcionario e chama
 * os metodos respectivos.
 * 
 * 	 A matricula de um objeto eh dada por uma classe GeradorMatricula, que possui uma variavel estatica para a matricula.
 * Esta classe tem um metodo geradorMatricula, que aumenta por uma unidade a variavel matricula, impedindo que haja repeticoes
 * de matriculas, e retorna este novo valor. Na criacao de um objeto aluno ou funcionario, o metodo eh chamado, e a matricula
 * do individuo eh o valor retornado
 */


public class Principal { //inicio da classe Principal
	//clase Principal que ira coordenar os processos feitos sobre as classes Funcionario e Aluno
	public static void main(String[] args) { //inicio da main
		Funcionario func1 = new Funcionario("Arthur", "51051051099"); //cria objeto funcionario func1
		Funcionario func2 = new Funcionario("Marcela", "18273742731"); //cria objeto funcionario func2
		Funcionario func3 = new Funcionario("Paulo", "83727374729"); //cria objeto funcionario func3
		
		Aluno aluno1 = new Aluno(Aluno.ATIVO, "joão", "11122233399", 40); //cria objeto aluno aluno1, ativo
		Aluno aluno2 = new Aluno(Aluno.INATIVO, "Marcos", "82838445672", 42); //cria objeto aluno aluno2, inativo
		Aluno aluno3 = new Aluno(Aluno.SUSPENSO,"Ana", "47482134591", 15); //cria objeto aluno aluno3, suspenso

		func1.imprimeDados(); //imprime func1 com os dados da funcao construtora
		func2.imprimeDados(); //imprime func2 com os dados da funcao construtora
		func3.imprimeDados(); //imprime func3 com os dados da funcao construtora

		aluno1.imprimeDados(); //imprime aluno1 com os dados da funcao construtora
		aluno2.imprimeDados(); //imprime aluno2 com os dados da funcao construtora
		aluno3.imprimeDados(); //imprime aluno3 com os dados da funcao construtora

		//testes das funcoes set para funcionario
		func1.setCPF("123"); //mudanca invalida
		func1.setCPF("12345678910"); //mudancao valida
		
		func1.setNome("b"); //mudanca invalida
		func1.setNome("Lorenzo"); //mudanca valida
		
		System.out.println("Funcionario 1 modificado");
		func1.imprimeDados(); //imprime dados de func1 mudados
		
		//testes das funcoes set para aluno
		aluno1.setCPF("123"); //mudancao invalida
		aluno1.setCPF("87823467452"); //mudanca valida
		
		aluno1.setNome("Bruno"); //mudanca valida
		aluno1.setNome("t"); //mudanca invalida
		
		aluno1.setAtividade(Aluno.INATIVO); //mudanca valida
		aluno1.setAtividade(2); //mudanca invalida
		
		System.out.println("Aluno 1 modificado");
		aluno1.imprimeDados();
	}//fim da main
	
}//fim de Principal
