/* Nome: Caio Augusto Alves Nolasco
 * RA: 195181
 * O programa a seguir simula um sistema de uma universidade, com classes Funcionario, Pessoa, Professor, Aluno e MeuArray. Explorando os conceitos
 * de heranca, sao criadas subclasses Funcionario, Aluno e Professor a partir da superclasse Pessoa, cada um com caracteristicas iguais entre si,
 * mas tambem com  atributos e metodos especificos para cada elemento. A classe MeuArray extende a classe ArrayList < Pessoa >, adicionando
 * metodos de organizacao alfabetica e impressao dependente do tipo de objeto em questao.
 * 
 *   */


public class Principal {

	public static void main(String[] args) {
		MeuArray listaPessoas = new MeuArray(); //cria classe MeuArray subclasse de ArrayList < Pessoa >
		
		listaPessoas.add(new Aluno("Joao", "12345678901", 42, 867596, Aluno.ATIVO));
		listaPessoas.add(new Aluno("Felipe", "45678912301", 84, 898324, Aluno.INATIVO));
		listaPessoas.add(new Aluno("Tomas", "78912345687", 31, 867521, Aluno.SUSPENSO));
		
		listaPessoas.add(new Funcionario("Maria", "86745632485", 753621, 1200.00));
		listaPessoas.add(new Funcionario("Yuri", "74732378582", 847312, 800.00));
		
		listaPessoas.add(new Professor("Eduardo", "68523496854", 938531, 2000.00));
		listaPessoas.add(new Professor("Thiago", "12395485623", 123459, 2500.00)); //adiciona Alunos Funcionarios e Professores a lista de pessoas
		
		System.out.println("#### Lista nao organizada:  ####");
		MeuArray.imprimeLista(listaPessoas); //imprime lista desorganizada usando metodo propio de impressao
		
		System.out.println("#### Lista organizada:  ####");
		MeuArray.organizaLista(listaPessoas); //ordena listaPessoas em ordem alfabetica por meio de metodo propio de bubble sort
		MeuArray.imprimeLista(listaPessoas); //imprime lista organizada usando metodo propio de impressao

	}

}
