import java.util.ArrayList;

public class Professor extends Pessoa{ //inicio da classe Professor
	
	private ArrayList < AlunoPos > alunosOrientados; //lista de alunos que o professor orienta
	
	public Professor (String nome, String CPF) {
		super(nome, CPF);
		alunosOrientados = new ArrayList < AlunoPos >();
	} //construtor para professor
	
	public Professor (String nome, String CPF, ArrayList < AlunoPos > alunosOrientados) {
		super(nome, CPF);
		this.alunosOrientados = alunosOrientados;
	} //outro construtor para para professor, com lista de alunos orientados

	public ArrayList < AlunoPos > getAlunosOrientados() {
		return alunosOrientados;
	} //metodo get para atributo de lista de alunos orientados
	
	public void adicionarAlunoOrientado ( AlunoPos aluno) {
		alunosOrientados.add(aluno);
	} //metodo para adicionar alunos a lista
	
	public AlunoPos removerAlunoOrientados (String nome) {
		for(AlunoPos alunoTemp : alunosOrientados) {
			if(alunoTemp.getNome().equalsIgnoreCase(nome)) {
				alunosOrientados.remove(alunoTemp);
				return alunoTemp;
			}
		}
		
		return null;
	} //metodo de remocao de alunos da lista
	
	@Override
	public void imprimeDados() { //override do metodo de Pessoa
		String saida = "########## Professor\n";
		saida = saida + "Nome: " + getNome() + "\n";
		saida = saida + "CPF: " + getCPF() + "\n";
		if(!alunosOrientados.isEmpty()) {
			saida = saida + "Alunos Orientados: \n";
			for(AlunoPos alunoTemp : alunosOrientados) {
				saida = saida + alunoTemp.getNome() + "\n";
			}
		} //se o professor tem algum aluno associado a ele
		System.out.println(saida);				
	} //metodo de impressao dos atributos de Professor
} //fim da classe Professor
