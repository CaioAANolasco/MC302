package locais;

import gerenciadores.GerenciadorClienteAluguel;
import gerenciadores.GerenciadorClienteGaragem;
import usuarios.Carro;
import usuarios.CarroAluguel;
import usuarios.ClienteAluguel;
import usuarios.ClienteGaragem;

public class Estacionamento {
	private int linhas;
	private int colunas;
	private AndarGaragem[] vetorAndares; //vetor de 4 andares para estacionamento
	private AndarAluguel andarDeAluguel; //andar de alugueis
	private GerenciadorClienteGaragem gerenciadorClienteGaragem;
	private GerenciadorClienteAluguel gerenciadorClienteAluguel;
	

	public Estacionamento(int linhas, int colunas, double[] precosGaragem, double diariaAluguel, double precoSeguro,
			int limiteMultas, double taxaMultas) {//inicio de metodo construtor
	
		AndarGaragem[] andares = new AndarGaragem[4];
		for (int i = 0; i < 4; i++) {
			andares[i] = (new AndarGaragem(linhas, colunas, i));
		} //inicia andares para estacionamento com numero de linhas e colunas especificado 
		
		this.linhas = linhas;
		this.colunas = colunas;
		gerenciadorClienteGaragem = new GerenciadorClienteGaragem(); //
		gerenciadorClienteAluguel = new GerenciadorClienteAluguel(); //
		gerenciadorClienteGaragem.setPrecoGaragem(precosGaragem);
		gerenciadorClienteAluguel.setDiariaValor(diariaAluguel); gerenciadorClienteAluguel.setLimiteMultas(limiteMultas);
		gerenciadorClienteAluguel.setSeguroValor(precoSeguro); gerenciadorClienteAluguel.setTaxaMultas(taxaMultas);
		//guarda os precoes dos servicoes nos gerenciadores
		vetorAndares = andares;
		andarDeAluguel = new AndarAluguel(5);	//inicia andar de alugueis
	} //fim de metodo construtor
	
	
	/*
	 * Método bscaClienteGaragem: chama metodo GerenciadorGaragem para busca
	 * param: placa
	 * return: clienteGaragem
	 */
	public ClienteGaragem buscaClienteGaragem(String placa) {
		return gerenciadorClienteGaragem.buscaCliente(placa);
	}
	
	
	
	/*
	 * Método estacionar: verifica se cliente é maior de idade, verifica localização válida para estacionar, se houver vaga estacionaCarro,
	 * caso contrário não é possível estacionar
	 * param: clienteGaragem, andar, linha, coluna
	 * return boolean 
	 */
	public boolean estacionarCarro (ClienteGaragem cliente, Carro carro, int andar, char linha, int coluna) {
		if(!cliente.calcularIdade(cliente.getDataDeNascimento())) {
			return false;
		}
		cliente.setCarro(carro); //recebe um cliente, seu carro e a vaga pretendida
		
		if(andar >= 4 || andar  < 0 || ((int)linha - 65) >= this.linhas || ((int)linha - 65) < 0 || coluna >= this.colunas || coluna < 0) {
			return false;
		}else {
			boolean estacionado = vetorAndares[andar].estacionarCarro(cliente, linha, coluna, andar); //verifica de vaga esta disponivel
			if(estacionado) {
				
				gerenciadorClienteGaragem.cadastrarCliente(cliente); //adiciona cliente a lista de cliente estacionados
				return true;
			}else {
				return false;
			}
		}
	}
	
	
	
	/*
	 * Método desestacionarCarro: avisa o sistema que o carro foi retirado, chama método gerenciadorClienteGaragem
	 * param: placa
	 * return: boolean 
	 */
	public ClienteGaragem desestacionarCarro (String placa) { 
		ClienteGaragem cliente = gerenciadorClienteGaragem.buscaCliente(placa); //busca dono do carro pretendido pela sua placa
		
		if(cliente != null) { //se existe carro com placa dada
			vetorAndares[cliente.getCarro().getAndarLocalizado()].desestacionarCarro(cliente); //invoca metodo de desestacionar de andar
			gerenciadorClienteGaragem.descadastrarCliente(cliente); //retira o cliente da lista de clientes
			return cliente;
		}
		
		return cliente;
	}
	
	
	
	/*
	 * Método desestacionarCarro: avisa o sistema que o carro foi retirado, chama método gerenciadorClienteGaragem
	 * param: cpf
	 * return: boolean 
	 */
	public ClienteGaragem desestacionarCarro (long CPF) { 
		ClienteGaragem cliente = gerenciadorClienteGaragem.buscaCliente(CPF); //busca dono do carro pretendido por seu CPF
		if(cliente != null) { //se existe carro com placa dada
			vetorAndares[cliente.getCarro().getAndarLocalizado()].desestacionarCarro(cliente); //invoca metodo de desestacionar de andar
			gerenciadorClienteGaragem.descadastrarCliente(cliente); //retira o cliente da lista de clientes
		}
		
		return cliente;
	}
	
	
	
	/*
	 * Método imprimirClienteGaragem: imprimir dado do cliente, com base na busca pelo cpf
	 * param: cpf
	 * return: String
	 */
	public String imprimirClienteGaragem(long CPF) {
		ClienteGaragem impresso = gerenciadorClienteGaragem.buscaCliente(CPF);
		String saida = impresso.imprimirCliente();
		return saida;
//		impresso.imprimirCliente(); //impressao de cliente da garagem
	}
	
	
	
	/*
	 * Método imprimirClienteAluguel: imprimir dado do cliente, com base na busca pelo cpf
	 * param: cpf
	 * return: String
	 */
	public String imprimirClienteAluguel(long CPF) {
		ClienteAluguel impresso = gerenciadorClienteAluguel.buscaCliente(CPF);
		String saida = impresso.imprimirCliente();
		return saida;
		
//		impresso.imprimirCliente(); //impresaao de cliente de aluguel
	}
		
	
	
	/*
	 * Método alugarCarro: verifica se há carro disponível, caso tenha cliente é cadastrado e carro é alugado
	 * invoca metodo de AndarAluguel para buscar um carro disponivel
	 * param: clienteAlguel
	 * return: boolean
	 */
	public boolean alugarCarro(ClienteAluguel cliente, int id) {
		CarroAluguel carroAlugado = andarDeAluguel.alugarCarro(cliente, id); 
		if(carroAlugado == null) {
			return false;
		}else {
			gerenciadorClienteAluguel.cadastrarCliente(cliente);
			return true;
		}
	}
	
	
	
	/*
	 * Método devolverCarro: com base na busca pela placa, verificar se carro existe e avisar o sistema que ele foi devolvido
	 * metodo polimorfico para devolucao do carro por sua placa
	 * param: placa
	 * return: boolean
	 */
	public double devolverCarro(long CPF, double quiloAtual) { 
		ClienteAluguel clienteAlugado = gerenciadorClienteAluguel.buscaCliente(CPF);
		CarroAluguel carroRetornado = andarDeAluguel.retornarCarro(clienteAlugado);
		
		if(clienteAlugado == null && carroRetornado == null ) {
			return -1;
		}else {
			return gerenciadorClienteAluguel.calcularMontante(clienteAlugado, quiloAtual, carroRetornado.getQuilometragem(), carroRetornado.getTipo());	
		}
	}
	
	
	
	/*
	 * Método devolverCarro: com base na busca pelo IDAlugado, verificar se carro existe e avisar o sistema que ele foi deolvido
	 * metodo polimorfico para devolucao do carro por seu ID de aluguel
	 * param: IDAlugado
	 * return: boolean
	 */
	public ClienteAluguel devolverCarro(int IDAlugado) { 
		ClienteAluguel clienteAlugado = gerenciadorClienteAluguel.buscaCliente(IDAlugado);
		//CarroAluguel carroRetornado = andarDeAluguel.retornarCarro(clienteAlugado);
		
		if(clienteAlugado == null) {
			return clienteAlugado;
		}else {
			return clienteAlugado;
		}
	}
	
	
	
	/*
	 * Método imprimirEstacionamento: imprimi mapa de vaga
	 * param:
	 * return: String 
	 */
	public String imprimirEstacionamento() { //metodo para impressao dos carros estacionado linearmente por andar
		String saida = "\n ----------IMPRIMINDO MAPA ESTACIONAMENTO ----------" + "\n";
	//	System.out.println("\n ----------IMPRIMINDO MAPA ESTACIONAMENTO ----------");
		
		int i = 0;
		for(i = 0 ; i < 4; i++) {

			saida = saida + "###### ANDAR NUMERO" + i + " / " + vetorAndares[i].getVagasDisponiveis() +  "VAGAS DISPONIVEIS ######" + "\n";
			saida = saida + vetorAndares[i].imprimirMapa();

		//	System.out.printf("###### ANDAR NUMERO %d / %d VAGAS DISPONIVEIS ######\n", i, vetorAndares[i].getVagasDisponiveis());
		//	vetorAndares[i].imprimirMapa();
		//	System.out.println();
		
		}
	//	System.out.println("####################\n");
		return saida;
	}
	
	
	
	/*
	 * Método imprimirAlugueis: imprimir carros disponíveis para aluguel
	 * param:
	 * return: String
	 */
	public String imprimirAlugueis() {
		String saida = andarDeAluguel.imprimirMapa();
		return saida;
		//	andarDeAluguel.imprimirMapa(); //impressao dos carros para aluguel
	}
	
	public GerenciadorClienteGaragem getClienteGaragem() {
		return this.gerenciadorClienteGaragem;
	}
	
	public GerenciadorClienteAluguel getClienteAluguel() {
		return this.gerenciadorClienteAluguel;
	}

} //fim da classe Estacionamento
