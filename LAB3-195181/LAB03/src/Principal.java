/* Nome: Caio Augusto Alves Nolasco
 * RA: 195181
 * 
 * O programa a seguir simula o sistema de uma universidade, com as classes Principal, Disciplina e Funcionario. Primeiramente, sao geradas
 * as disciplinas a partir das informacoes providas por um sistema legado, em forma de uma matriz. A matriz eh percorrida, sendo instanciados objetos
 * Disciplina com os dados fornecidos. Um vetor de alunos matriculados eh recuperado, e os alunos deste vetor sao cadastrados nas respectivas  disicplinas
 * Um outro vetor, contendo alunos para serem removidos, eh recebido do sistema legado, e estes alunos sao retirados do cadastro.
 * 
 * Posteriormente, o sistema legado fornece dados sobre funcionarios. Os dados destes sao usados para criar objetos de Funcionario, e estes objetos
 * sao adicionados a um ArrayList que guarda todas as pessoas cadastradas, para cada objeto criado.
 */

import mc302ef.GerenciadorDisciplinas;
import mc302ef.GerenciadorFuncionarios;
import java.util.ArrayList; //importa classes do pacote mc302ef e os metodos de AraryList

public class Principal {	
	public static void main(String[] args) {
		/*
		 * Parte 1
		 * Leitura de disciplinas e alunos
		 */
		String[][] disciplinas_info = GerenciadorDisciplinas.getDisciplinas();
		int discId;
		String discNome; //le a matriz de disciplinas
		
		Disciplina[] listaDisciplinas = new Disciplina[2]; //cria vetor para armazenar dados das disciplinas

		for (int i = 0; i < disciplinas_info.length; i++) {
			discId = Integer.parseInt(disciplinas_info[i][0]);
			discNome = disciplinas_info[i][1]; 
			
			listaDisciplinas[i] = new Disciplina(discId, discNome); //instancia novo objeto disciplina com dados resgatados

			int[] matriculasAlunos = GerenciadorDisciplinas.getAlunosPorDisciplina( discId );
			
			for( int j =  0; j < matriculasAlunos.length; j++)
				listaDisciplinas[i].adicionarMatricula(matriculasAlunos[j]); //adiciona matriculas dos alunos registrados na disciplina
			
		}
		System.out.println("\nDisciplinas antes da remocao: \n");
		listaDisciplinas[0].imprimirDisciplina();
		listaDisciplinas[1].imprimirDisciplina(); //imprime lista de matriculados antes da remocao de alunos

		/*
		 * Parte 2
		 * Busca/remoção e exibição
		 */
		int[] alunos_para_remover = GerenciadorDisciplinas.getAlunosARemover(); //le vetor de matriculas a serem removidas

		for(int i = 0; i < listaDisciplinas.length; i++) {
			for(int j = 0; j < alunos_para_remover.length; j++) {
				listaDisciplinas[i].removerMatricula(alunos_para_remover[j]);
			} //remove de cada disciplina os alunos presentes no vetor de alunos para serem removidos
		}
		
		System.out.println("\nDisciplinas depois da remocao: \n");
		
		listaDisciplinas[0].imprimirDisciplina();
		listaDisciplinas[1].imprimirDisciplina(); //imprime lista de matriculas apos a remocao
		
		/*
		 * Parte 3
		 * Cadastro de funcionários
		 */
		
		GerenciadorFuncionarios sim = new GerenciadorFuncionarios();
		String[] funcionario_info;
		String funcNome, funcCPF;
		ArrayList <Funcionario> listaFunc = new ArrayList <Funcionario> ();//Estrutura para armazenar instâncias de funcionários
		while ( (funcionario_info = sim.getNextFuncionario()) != null) {
			funcNome = funcionario_info[GerenciadorFuncionarios.NOME];
			funcCPF = funcionario_info[GerenciadorFuncionarios.CPF];
			
			Funcionario func1 = new Funcionario(funcNome, funcCPF);
			listaFunc.add(func1); //instancia de novo objeto funcionario e adiciona ele a lista ligada de funcionarios
		}
		System.out.println("\nFuncionarios: ");
		System.out.println(listaFunc.toString()); //imprime dados da lista de funcionarios
		listaFunc.get(0).imprimeDados();; //teste para pegar o primeiro elemento da lista ligada e imprime seus dados
	}
}