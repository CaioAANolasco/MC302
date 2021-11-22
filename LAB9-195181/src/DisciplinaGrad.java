
public class DisciplinaGrad extends Disciplina { //inicio de DisciplinaGrad
	
	public DisciplinaGrad(int id, String nome) {
		super(id, nome);
	}

	@Override
	public boolean addAluno(Aluno novoAluno) {
		
		if(novoAluno instanceof AlunoPos) {
			System.out.println("Aluno de pos graduacao nao pode ser matriculado em disciplinas da graduacao");
			return false;
		}
		
		if(listaAlunos.size() < 25) { //se tem espaco disponivel
			listaAlunos.add(novoAluno); //adiciona elemento a lista, simultaneamente com metodo de adicao de Aluno
			return true;
		}else {
			System.out.println("Disciplina " + id + " " + this.getNome() + " esta cheia");
			return false; //se nao tem espaco
		}
	}

} //fim de DisciplinaGrad
