/* Nome: Caio Augusto Alves Nolasco
 * RA: 195181
 * 
 * 		O laboratorio 6 a seguir extende o sistema administrativo de uma universidade que vem sido desenvolvido nos laboratorios anteriores.
 * Aqui, eh implementado o conceito de uma classe Curso que armazena os alunos e disciplinas associados , gerenciada por um classe 
 * RepositorioDeCursos responsavel por guardar em uma lista todos os cursos instanciados e eventuais remocoes. 
 * 		A classe Aluno agora tambem eh associada a um objeto Curso, e similarmente a classe Disciplina, lida com a ideia de creditos, sendo o limite
 * de creditos de um aluno imposto pelo  matriculado. Um objeto Disciplina tambem contem um atributo de creditos, dependente
 * da carga horaria da disciplina.
 * 		Para um aluno requerir a realizacao de matricula em uma disciplina, exista agora uma classe propia para o processo chamada ControladorDeMatricula
 * que contem uma classe interna Solicitacao, cujos objetos guardam os objetos aluno e disciplina atrelados ao requerimento de matricula.
 * Todas as solicitacoes sao armazenadas, ate que eh evocado o metodos de processamento dos pedidos armazenados, verificando que a solicitacao
 * nao quebraram as regras de um aluno ter mais creditos do que o permitido, rejeitando o pedido caso esse seja o caso.
 * 
 */

public class Principal { //inicio da classe Principal

	public static void main(String[] args) { //main
		
		//########### TESTES SOBRE AS FUNCIONALIDADES DOS CONCEITOS DE CURSO IMPLEMENTADOS #################
		Curso c1 = RepositorioDeCursos.adicionarCurso("Curso1", 40,  6);
		Curso c2 = RepositorioDeCursos.adicionarCurso("Curso2", 41, 30);
		Curso c3 = RepositorioDeCursos.adicionarCurso("Curso3", 42, 16); //cria tres cursos, inclusive c1 com limite de creditos iguais a 6
	
		Aluno a1 = new Aluno("Joao", "12345678901", c1); //cria novo aluno no curso Curso1
		
		Disciplina d1 = new Disciplina (202, "Disc1", 48); //3 creditos
		c1.adicionaDisciplina(d1);
		Disciplina d2 = new Disciplina (302, "Disc2", 32); //2 creditos
		c1.adicionaDisciplina(d2); c2.adicionaDisciplina(d2);
		Disciplina d3 = new Disciplina (402, "Disc3", 64); //4 creditos
		c1.adicionaDisciplina(d3); c2.adicionaDisciplina(d3); c3.adicionaDisciplina(d3);
		//instancia novas disciplinas e inclui elas cursos arbritarios
		
		RepositorioDeCursos.imprimeCursos(); //chama metodo para impressao de cursos
		
		ControladorDeMatricula.solicitarMatricula(d1, a1);
		ControladorDeMatricula.solicitarMatricula(d2, a1);
		ControladorDeMatricula.solicitarMatricula(d3, a1); //solicita matricula de aluno a1 nas tres disciplinas criadas
		
		ControladorDeMatricula.realizaMatriculas(); //processa os requerimentos de a1, dos quais d3 nao sera aceito
		
		d1.imprimeDados();
		d2.imprimeDados();
		d3.imprimeDados(); //imprime dados das disciplinas, sendo que d3 nao tem aluno a1, pois a solicitacao eh tida como invalida
		
		
		//############ TESTE DAS FUNCOES DE CANCELAMENTO DE MATRICULA DE UM ALUNO EM SEU CURSO ###############
		ControladorDeMatricula.realizaMatriculas(); 
				
		a1.cancelarMatricula(); //matricula de aluno a1 eh cancelada
		RepositorioDeCursos.imprimeCursos(); //imprime catalogo de cursos, dessa vez sem aluno a1
				
		d1.imprimeDados();
		d2.imprimeDados();
		d3.imprimeDados();//imprime novamento os dados das disciplinas, apos a1 ter sua matricula em seu curso cancelada
		
		//########## TESTE DAS FUNCOES DE CONTROLE SOBRE REQUERIMENTOS DE MATRICULAS ###############
		Aluno alunoAcimaLimite = new Aluno ("Roberto", "83422134521", c1);
		ControladorDeMatricula.solicitarMatricula(d1, alunoAcimaLimite);
		ControladorDeMatricula.solicitarMatricula(d2, alunoAcimaLimite); //aluno Roberto faz duas solicitacoes que serao aceitas, mas posteriormente fara
		//uma solicitacao que sera recusada por passar do limite de seu creditos aceitos
		
		ControladorDeMatricula.solicitarMatricula(d3, alunoAcimaLimite); //aluno acimaDoLimite ja passou do limite de creditos, e seu requerimento sera rejeitado
		Aluno a2 = new Aluno("Zidane", "23456789012", c2); ControladorDeMatricula.solicitarMatricula(d3, a2);
		Aluno a3 = new Aluno("Vivi", "34564367854", c1); ControladorDeMatricula.solicitarMatricula(d3, a3);
		Aluno a4 = new Aluno("Steiner", "29485930123", c3); ControladorDeMatricula.solicitarMatricula(d3, a4);
		Aluno a5 = new Aluno("Quina", "93858341235", c3); ControladorDeMatricula.solicitarMatricula(d3, a5);
		Aluno a6 = new Aluno("Dagger", "82312345612", c2); ControladorDeMatricula.solicitarMatricula(d3, a6);
		Aluno a7 = new Aluno("Amarant", "95838123456", c1); ControladorDeMatricula.solicitarMatricula(d3, a7);
		Aluno a8 = new Aluno("Freya", "21235552123", c2); ControladorDeMatricula.solicitarMatricula(d3, a8);
		Aluno a9 = new Aluno("Joca", "54312345678", c3); ControladorDeMatricula.solicitarMatricula(d3, a9);
		Aluno a10 = new Aluno("Paulo", "23456778931", c1); ControladorDeMatricula.solicitarMatricula(d3, a10);
		Aluno a11 = new Aluno("Marcia", "92352212344", c2); ControladorDeMatricula.solicitarMatricula(d3, a11);
		Aluno a12 = new Aluno("Lopes", "21233324566", c1); ControladorDeMatricula.solicitarMatricula(d3, a12);
		Aluno a13 = new Aluno("Karen", "99992324412", c3); ControladorDeMatricula.solicitarMatricula(d3, a13);
		Aluno a14 = new Aluno("Pablo", "98883421123", c3); ControladorDeMatricula.solicitarMatricula(d3, a14);
		Aluno a15 = new Aluno("Paola", "83331231452", c2); ControladorDeMatricula.solicitarMatricula(d3, a15);
		Aluno a16 = new Aluno("Iago", "98823412356", c1); ControladorDeMatricula.solicitarMatricula(d3, a16);
		Aluno a17 = new Aluno("Luan", "99098212563", c2); ControladorDeMatricula.solicitarMatricula(d3, a17);
		Aluno a18 = new Aluno("Sofia", "42235123561", c2); ControladorDeMatricula.solicitarMatricula(d3, a18);
		Aluno a19 = new Aluno("Dalva", "12463342157", c3); ControladorDeMatricula.solicitarMatricula(d3, a19);
		Aluno a20 = new Aluno("Daria", "86788445713", c1); ControladorDeMatricula.solicitarMatricula(d3, a20);
		Aluno a21 = new Aluno("Hector", "99823451234", c2); ControladorDeMatricula.solicitarMatricula(d3, a21);
		Aluno a22 = new Aluno("Rafael", "12355343312", c3); ControladorDeMatricula.solicitarMatricula(d3, a22);
		Aluno a23 = new Aluno("Renata", "82356411125", c1); ControladorDeMatricula.solicitarMatricula(d3, a23);
		Aluno a24 = new Aluno("Kim", "13553413213", c2); ControladorDeMatricula.solicitarMatricula(d3, a24);
		Aluno a25 = new Aluno("Gabriel", "92113412345", c2); ControladorDeMatricula.solicitarMatricula(d3, a25);
		Aluno a26 = new Aluno("Bob", "75643594523", c3); ControladorDeMatricula.solicitarMatricula(d3, a26);
		
		/*Sao criados 26 alunos, e todos realizao um requerimento para matricula em disciplina d3, que tem limite de aluno igual
		 * a 25. Porem, um dos requerimentos eh de aluno a1, que passaria do limite de creditos aceito se fosse matriculado em d3, e por
		 * isso tera sua matricula rejeitada. Entao, o aluno a26, que nao entraria antes por falta se espaco, agora tera sua solicitacao aceita
		*/
		
		ControladorDeMatricula.realizaMatriculas(); //processa predidos feitos
		
		//############## TESTE DE REMOCAO DE UM CURSO
		
		RepositorioDeCursos.removerCurso("Curso3"); //retira o curso Curso3, como exemplo
		RepositorioDeCursos.imprimeCursos(); //imprime nova lista de cursos
		
	} //fim da main
}//fim da classe Principal

