import java.util.ArrayList;

public class ControladorDeMatricula { //inicio da classe ContraladorDeMatricula
	
	private static ArrayList< Solicitacao > listaSolicitacoes = new ArrayList < Solicitacao >(); //lista estatica de requerimentos de matricula
	
	public static void solicitarMatricula (Disciplina disciplina, Aluno aluno) {
		
		if(!disciplina.checaCheia()) {
			Solicitacao s1 = new Solicitacao (aluno, disciplina);
			listaSolicitacoes.add (s1);
		} //se disciplina nao esta cheia, cria um requerimento para certo aluno e armazena o pedido
		
	} //metodo para criacao de solicitacao de matricula
	
	public static void realizaMatriculas() { //processa todos os requerimento armazenados
		for(Solicitacao solTemp : listaSolicitacoes) { //percorre lista de solicitacoes
			if((solTemp.getAluno().getCreditosAtuais() + solTemp.getCreditosAddDisc()) <= solTemp.getCreditosCursoAluno()) {
				//se nao ultrapassa o limite de creditos do curso em que aluno esta matriculado
				solTemp.getAluno().incluidDisciplinaLista(solTemp.getDisciplina());
				solTemp.getAluno().adicionaCreditos(solTemp.getCreditosAddDisc()); //adiciona disciplina na lista de disciplina de aluno e aumenta creditos
				solTemp.getDisciplina().incluiAlunoLista(solTemp.getAluno()); //adiciona aluno na lista de alunos de disciplina
				System.out.println("Aluno " + solTemp.getAluno().getNome() + " matriculado na disciplina " +
						solTemp.getDisciplina().getNome() + ". CreditosAtuais: " + solTemp.getAluno().getCreditosAtuais());
			}
			else {
				System.out.println("Aluno " + solTemp.getAluno().getNome() + " ultrapassou o limite de creditos, "
						+ "nao foi matriculado na disciplina " + solTemp.getDisciplina().getNome()); //se limite foi ultrapassado
			}
		}
		
		listaSolicitacoes.clear(); //limpa lista depois de que os requerimentos foram processados
	} //metodo para aprovacao ou reprovacao dos pedidos de matricula
	
	public static class Solicitacao { //inicio da classe estatica interna Solicitacao
		
		private Aluno aluno;
		private Disciplina disciplina;
		private int creditosCursoAluno;
		private int creditosAddDisc; //guarda aluno e disciplina da solicitacao, assim como limite para o aluno e num de creditos de disciplina, por conviniencia
		
		public Solicitacao (Aluno aluno, Disciplina disciplina) {
			this.aluno = aluno;
			this.disciplina = disciplina;
			
			creditosCursoAluno = aluno.getCursoMatriculado().getCreditosMax();
			creditosAddDisc = disciplina.getCreditosDisc();
		} //metodo construtor de Solicitacao
		
		public Aluno getAluno() {
			return this.aluno;
		} //metodo get para Aluno
		
		public Disciplina getDisciplina() {
			return this.disciplina;
		} //metodo get para Disciplina
		
		public int getCreditosAddDisc() {
			return this.creditosAddDisc;
		} //metodo get para creditosAtuais
		
		public int getCreditosCursoAluno() {
			return this.creditosCursoAluno;
		} //metodo get para creditosCursoAluno
		
		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		} //metodo set para aluno
		
		public void setDisciplina (Disciplina disciplina) {
			this.disciplina = disciplina;
		} //meotod set para disciplina
	} //fim da classe interna Solicitacao
}//fim da classe ControladorDeMatricula
