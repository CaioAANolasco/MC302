import java.util.ArrayList;

public class RepositorioDeDisciplinas { //inicio da classe RepositorioDeDisciplinas
	
	private static ArrayList < Disciplina> listaDisciplina = new ArrayList < Disciplina >(); //lista de disciplinas registradas
	
	public static void adicionarDisciplina (Disciplina novaDisciplina) {
		listaDisciplina.add(novaDisciplina);
	} //metodo para adicionar uma disciplina da lista
	
	public static Disciplina removerDisciplina (String nomeDisciplina) {
		Disciplina discTemp = buscaDisciplina (nomeDisciplina);
		if(discTemp != null) {
			listaDisciplina.remove(discTemp);
		}
		
		return discTemp;
	} //metodo para remover uma disciplina da lista
	
	public static Disciplina buscaDisciplina (String nome) { //polimorfismo da busca
		for(Disciplina discTemp : listaDisciplina) {
			if(discTemp.getNome().equalsIgnoreCase(nome)) {
				return discTemp;
			}
		}
		
		return null;
	} //metodo de busca de disciplina, usando nome como parametro
	
	public static Disciplina buscaDisciplina (int id) { //polimorfismo da busca
		for(Disciplina discTemp : listaDisciplina) {
			if(discTemp.getID() == id) {
				return discTemp;
			}
		}
		
		return null;
	} //metodo de busca de disciplina, usando id como parametro
} //fim da classe RepositorioDeDisciplinas
