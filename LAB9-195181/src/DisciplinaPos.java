
public class DisciplinaPos extends Disciplina { //inicio de DisciplinaPos
	
	public DisciplinaPos(int id, String nome) {
		super(id, nome);
	}

	@Override
	public boolean addAluno (Aluno novoAluno) {
		if(listaAlunos.size() < 25) { //se tem espaco disponivel
			listaAlunos.add(novoAluno); //adiciona elemento a lista, simultaneamente com metodo de adicao de Aluno
			return true;
		}else {
			System.out.println("Disciplina " + id + " " + getNome() + " esta cheia");
			return false; //se nao tem espaco
		}
	}
} //fim de DisciplinaPos
