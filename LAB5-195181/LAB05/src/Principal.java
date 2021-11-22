/* Nome: Caio Augusto Alves Nolasco
 * RA: 195181
 * 
 * 	O laboratorio a seguir continua o sistema desenvolvido nos laboratorios anteriores, simulando o sistema de uma universidade.
 *Nesta parta, sao criadas subclasses de Aluno, AlunoGraduacao e AlunoPos, e mais duas subclasses de AlunoPos, AlunoMestrado e AlunoDoutorado.
 *Cada subclasses contem em si um atributo que representa o prazo em anos para a conclusao do periodo escolar, diferente dependendo do tipo
 *de aluno. Uma lista de objetos Disciplina eh implementada na classe Aluno.
 *	Eh tambem modificada a classe Disciplina, desta vez contendo uma lista ligada de alunos, formando uma agregacao com a classe Aluno.
 *Cada vez que um aluno eh adicionado a uma disciplina, esta disciplina eh adicionada simultaneamente a lista do objeto Aluno.
 *	Os dados de cada aluno e das disciplinas sao derivados de uma sistema legado que fornece as informacoes.
*/

import mc302ef.GerenciadorAlunos;
import mc302ef.GerenciadorDisciplinas; //importa biblioteca mc302ef
import java.util.ArrayList;

public class Principal { //inicio da classe Principal

	public static void main(String[] args) { //inicio de Main
		
		ArrayList < Aluno > alunosRegistrados = new ArrayList < Aluno >(); //lista de alunos matriculados
		ArrayList < Disciplina > disciplinasRegistradas = new ArrayList < Disciplina >(); //lista de disciplinas ministradas
		String[][] disciplinasInfo = GerenciadorDisciplinas.getDisciplinas(); //matriz de disiciplinas
		int discId;
		String discNome;

		for (int i = 0; i < disciplinasInfo.length; i++) {
			discId = Integer.parseInt(disciplinasInfo[i][GerenciadorDisciplinas.ID]);
			discNome = disciplinasInfo[i][GerenciadorDisciplinas.NOME]; 
			
			Disciplina novaDisciplina = new Disciplina(discId, discNome);
			disciplinasRegistradas.add(novaDisciplina); //instancia novo objeto disciplina com dados resgatados e adiciona a lista
		}
			
		testaInclusaoAlunos(alunosRegistrados); //chama metodos de criacao de objetos alunos
		testaInscricaoEmDisciplinas(alunosRegistrados, disciplinasRegistradas); //cadastra alunos em suas disciplinas
		
		for(Disciplina discTemp : disciplinasRegistradas) {
			discTemp.imprimeDados(); //imprime os CPF's dos alunos de cada disciplina
		}
		
	} //fim da Main
		
		public static void testaInclusaoAlunos( ArrayList < Aluno > alunosCriados) { //inicio do metodo testaInclusaoAlunos
			/*
			 * Leitura de informação de alunos e suas instanciações.
			 */
			ArrayList<String[]> infoAlunos = GerenciadorAlunos.getListaAlunos();
			String vinculo, nome, cpf;
			int curso;
			
			for (String[] campo : infoAlunos) {
				vinculo = campo[GerenciadorAlunos.I_VINCULO];
				nome    = campo[GerenciadorAlunos.I_NOME];
				cpf     = campo[GerenciadorAlunos.I_CPF];
				curso   = Integer.parseInt( campo[GerenciadorAlunos.I_CURSO] ); //resgata dados do sistema legado
				
				if (vinculo.equalsIgnoreCase(GerenciadorAlunos.GRADUACAO) ) {
					AlunoGraduacao alunoGrad = new AlunoGraduacao (nome, cpf, curso);
					alunoGrad.imprimeDados();
					
					alunosCriados.add(alunoGrad); //se eh aluno de graduacao, cria objeto respectivo e adiciona a lista
				} else {
					/*
					 * Utilize:
					 * 		'campo[GerenciadorAlunos.I_QUALIFICADO]' e
					 * 		'campo[GerenciadorAlunos.I_INGLES_APROVADO]'
					 * para obter informações sobre o estado da qualificação e da comprovação de proeficiência em inglês
					 * dos alunos de pós-graduação.
					 */
				
					if (vinculo.equalsIgnoreCase(GerenciadorAlunos.MESTRADO) ) {
						AlunoMestrado alunoMest = new AlunoMestrado (nome, cpf, curso);
						alunoMest.setIsExameQualificacaoAprovadoMestrado(Boolean.parseBoolean(campo[GerenciadorAlunos.I_QUALIFICADO]));
						alunoMest.setIsInglesComprovadoMestrado(Boolean.parseBoolean(campo[GerenciadorAlunos.I_INGLES_APROVADO]));
						//seta valores correspondentes aos booleanos de AlunoMestrado
						alunoMest.imprimeDados();
						
						//se eh aluno de mestrado, cria objeto respectivo e adiciona a lista
						alunosCriados.add(alunoMest);
					} else if (vinculo.equalsIgnoreCase(GerenciadorAlunos.DOUTORADO) ) {
						AlunoDoutorado alunoDout = new AlunoDoutorado (nome, cpf,curso);
						alunoDout.setIsExameQualificacaoAprovadoDoutorado(Boolean.parseBoolean(campo[GerenciadorAlunos.I_QUALIFICADO]));
						alunoDout.setIsInglesComprovadoDoutorado(Boolean.parseBoolean(campo[GerenciadorAlunos.I_INGLES_APROVADO]));
						//seta valores correspondentes aos booleanos de AlunoDoutorado
						alunoDout.imprimeDados();
						
						//se eh aluno de doutorado, cria objeto respectivo e adiciona a lista
						alunosCriados.add(alunoDout);
					}
				}
				
			}
		} //fim do metodo testaInclusaoAluno
		
		public static void testaInscricaoEmDisciplinas( ArrayList < Aluno > alunos, ArrayList < Disciplina > disciplinas) {
		//inicio do metodo testaInscricaoEmDisciplanas
			ArrayList<String[]> infoAlunos = GerenciadorAlunos.getDisciplinasPorCpfAluno();
			//le vetores de disciplinas por aluno
			String cpfAluno;
			int idDisciplina;
			
			for (String[] params : infoAlunos) {
				//percorre lista de disciplinas resgatada
		
				cpfAluno = params[0]; //le CPF do aluno

				Aluno alunoMatriculas = null;
				for(Aluno alunoTemp : alunos) {
					if(cpfAluno.equals(alunoTemp.getCPF())) {
						alunoMatriculas = alunoTemp;
						break; //procura objeto aluno com CPF em questao
					}
				}
				
				for (int i = 1; i < params.length; i++) {
					idDisciplina = Integer.parseInt(params[i]); //le ID de disciplina
					Disciplina disciplinaMatricula = null;
					
					for(Disciplina disciplinaTemp : disciplinas) {
						if(disciplinaTemp.getID() == idDisciplina) { //percorre lista de disciplina procurando ID dado
							disciplinaMatricula = disciplinaTemp;
							break;
						}
					}
					
					alunoMatriculas.adicionaDisciplina(disciplinaMatricula); //adiciona disciplina a lista de Aluno, que por sua vez
					//adiciona o Aluno na lista de Disciplina
					
				}
			}
			
		} //fim do metodo testaInscricaoEmDisciplinas

}//fim da classe Principal
