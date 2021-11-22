/**
 * 
 * @author Caio Nolasco
 *
 *Nome: Caio Augusto Alves Nolasco
 *RA: 195181
 *
 *	Este laboratorio 9 tem o intuito de dar continuidade ao sistema de administracao de uma universidade, desenvolvido nos laboratorios anteriores.
 *Mais especificamente, sao exercitados os conceitos de interface em java, criando uma interface Imprimivel para os objetos que compartilha um 
 *metodo de impressao de dados.
 *	Eh tambem implementada a interface Enumeration sobre as classes RepositorioDeCursos e Disciplina para lidar com a iteracao de objetos Curso
 *e Aluno, respectivamente. Para possibilitar a ordenacao de elementos das lista de armazenamento, tambem se inclui a interface Comparable sobre as 
 *classes Pessoa, Disciplina, Curso e Aluno, para possibilitar reoordenar objetos por metodos de Array e Collections.
 *	A classe MeuArray, usada em laboratorios anteriores, eh descontinuada neste, pois suas funcoes sao substituidas pelo uso das interfaces.
 */
public class Principal { //inicio da classe Principal

	public static void main(String[] args) { 
		
		RepositorioDeCursos repositorioCursos = new RepositorioDeCursos(); //novo repositorio de cursos
		
		Curso curso1 = new Curso ("Matematica", 1, 40);
		Curso curso2 = new Curso ("Engenharia de Alimentos", 2, 44);
		Curso curso3 = new Curso ("Direito", 3, 40);
		Curso curso4 = new Curso ("Jornalismo", 4, 42);
		Curso curso5 = new Curso ("Geologia", 5, 38); //criacao de cursos a fim de exemplo
		
		repositorioCursos.adicionarCurso(curso1);
		repositorioCursos.adicionarCurso(curso2);
		repositorioCursos.adicionarCurso(curso3);
		repositorioCursos.adicionarCurso(curso4);
		repositorioCursos.adicionarCurso(curso5);
		repositorioCursos.adicionarCurso("Quimica", 6, 40); //adiciona os cursos criados no repositorio por metodo polimorfico
		
		Disciplina disc1 = new DisciplinaGrad(101, "Calculo 1"); //cria uma nova disciplina
		curso1.adicionaDisciplina(disc1);
		curso2.adicionaDisciplina(disc1); //adiciona a disciplina disc1 nos cursos Matematica e Engenharia de Alimentos
		
		Aluno aluno1 = new AlunoGraduacao ("Zidane", 123456, "12345678901", curso1);
		Aluno aluno2 = new AlunoGraduacao ("Vivi", 198423, "98743421232", curso2);
		Aluno aluno3 = new AlunoGraduacao ("Freya", 182374, "28475323453", curso1);
		//cria 3 alunos novos, 2 de Matematica e 1 de Engenharia
		
		disc1.addAluno(aluno1);
		aluno1.adicionarNota(4);
		disc1.addAluno(aluno2);
		aluno2.adicionarNota(8);
		disc1.addAluno(aluno3);
		aluno3.adicionarNota(10);
		//adiciona os tres novos alunos na disciplina de Calculo 1 e da uma nota a eles para o calculo de seu CR
		
		Imprimivel imprimivel;
		//variavel da interface Imprimivel
		
		System.out.println("\n####### CURSOS NAO ORDENADOS #######");
		while(repositorioCursos.hasMoreElements()) { //enquanto ainda ha cursos no repositorio
			imprimivel = repositorioCursos.nextElement(); //pega o proximo elemento
			imprimivel.imprimeDados(); //chama o metodo da interface Imprimivel
		} //impressao usando a interface Enumeration
		
		System.out.println("\n####### CURSOS ORDENADOS #######");
		repositorioCursos.organizarCursos(); //ordena os cursos em ordem lexicografica
		
		while(repositorioCursos.hasMoreElements()) {
			imprimivel = repositorioCursos.nextElement();
			imprimivel.imprimeDados();
		} //impressao usando a interface Enumeration, desta vez com cursos ordenados 
		
		System.out.println("\n####### ALUNOS NAO ORDENADOS #######");
		
		//impressao de alunos em disc1, Calculo 1
		while(disc1.hasMoreElements()) { //enquanto ainda tem alunos em disc1
			imprimivel = disc1.nextElement(); //pega o proximo elemento
			imprimivel.imprimeDados(); //chama o metodo de Imprimivel
		}//impressao usando a interface Enumeration
		
		disc1.ordenarAlunos(); //ordena os alunos em disc1 por ordem crescente de matricula
		System.out.println("\n####### ALUNOS ORDENADOS #######");
		
		while(disc1.hasMoreElements()) { //enquanto ainda elementos
			imprimivel = disc1.nextElement();
			imprimivel.imprimeDados();
		} //impressao usando a interface Enumeration, alunos ordenados
	}
} //fim da classe Principal
