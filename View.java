package projeto_Borracharia_JJ;

import javax.swing.JOptionPane;

public class View {
	int qttServicos=0;
	public void menu (Cliente[] clientes, Servico[] servicos){
		View aux = new View();
		Object[] options = {
				"Clientes",
				"Serviços",
				"Finalizar programa"
		};
		int op = JOptionPane.showOptionDialog(null,
				"Menu",
				"Borracharia JJ",
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]
				);
		
		switch (op){
		case 0 : 
			// Clientes
			Object[] optionsCliente = {"Cadastrar", "Visualizar", "Alterar", "Excluir"};
			int opCliente = JOptionPane.showOptionDialog(null,
					"Escolha uma opção",
					"Borracharia JJ",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					null,
					optionsCliente,
					optionsCliente[0]);
			
				switch(opCliente){
				case 0:
					aux.obterCliente(clientes);
					break;
					
				case 1:
					aux.visualizarCliente(clientes);
					break;
					
				case 2:
					aux.alterarCliente(clientes);
					break;
					
				case 3:
					aux.excluirCliente(clientes);
					break;
				}
			break;
		case 1:
			// Serviços
			Object[] optionsServico = {"Cadastrar", "Visualizar", "Alterar", "Excluir"};
			int opServico = JOptionPane.showOptionDialog(null,
					"Escolha uma opção",
					"Borracharia JJ",
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					optionsServico,
					optionsServico[0]);
			switch(opServico) {
			case 0:
				aux.obterServico(clientes, servicos);
				break;
				
			
			}
			
			break;
			
		case 2:
			// Finalizar Programa
			System.exit(0);
			break;
		
			
			
		}
		menu(clientes, servicos);
	}
	 



	public void obterCliente(Cliente[] clientes){
		 Object[] options = {"Sim", "Não"};
		 int vip = JOptionPane.showOptionDialog(null,
				 "O cliente é VIP?",
				 "Borracharia JJ",
				 JOptionPane.DEFAULT_OPTION,
				 JOptionPane.QUESTION_MESSAGE,
				 null,
				 options,
				 options[0]);
		 String nome = JOptionPane.showInputDialog("Nome:");
		 String endereco = JOptionPane.showInputDialog("Endereço:");
		 int telefone = Integer.parseInt(JOptionPane.showInputDialog("Telefone:"));
		 int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF:"));
		 String automovel = JOptionPane.showInputDialog("Automóvel:");
		 String modelo = JOptionPane.showInputDialog("Modelo:");
		 double km = Double.parseDouble(JOptionPane.showInputDialog("KM:"));
		 double estimativakm = Double.parseDouble(JOptionPane.showInputDialog("Estimativa Km/mês:"));
		 if (vip == 0){
			 int nivelVIP = Integer.parseInt(JOptionPane.showInputDialog("Nível VIP:"));
			 int nulo = Cliente.proxNulo(clientes);
			 clientes[nulo] = new ClienteVIP(nome, endereco, telefone, cpf, automovel, modelo, km, estimativakm, nivelVIP);
			 clientes[nulo].calculaDesconto(clientes[nulo]);
		 } else {
			 int nulo = Cliente.proxNulo(clientes);
			 clientes[nulo] = new Cliente(nome, endereco, telefone, cpf, automovel, modelo, km, estimativakm);
			 clientes[nulo].calculaDesconto(clientes[nulo]);
		 }
	 }
	 
	public void visualizarCliente(Cliente[] clientes){
		 int quem = Integer.parseInt(JOptionPane.showInputDialog("CPF do Cliente: "));
		 String tipoDeCliente = null;
		 for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] != null) {
				if (quem == clientes[i].cpf){
					clientes[i].calculoRevisao(clientes[i]);
					int tipo = clientes[i].tipoDeCliente(clientes);
					if (tipo == 0) {
						tipoDeCliente = "Normal"; 
					} else {
						tipoDeCliente = "VIP";
					}
					JOptionPane.showMessageDialog(null,
							"Nome: " + clientes[i].nome +
							"\nTipo de cliente: " + tipoDeCliente +
							"\nEndereço: " + clientes[i].endereco +
							"\nTelefone: " + clientes[i].telefone +
							"\nCPF: " + clientes[i].cpf +
							"\nAutomóvel: " + clientes[i].automovel +
							"\nModelo: " + clientes[i].modelo +
							"\nQuilometragem: " + clientes[i].km +
							"\nEstimativa: " + clientes[i].estimativakm +
							"\nData da revisão: " + clientes[i].mesesRevisao + " meses" +
							"\nDesconto: " + clientes[i].desconto +
							"\nNível VIP: " + clientes[i].nivelVIP +
							"\nServiços feitos na borracharia: " + clientes[i].qttServicos
							);
				} else {
					JOptionPane.showMessageDialog(null, "Este cliente não está cadastrado!"+
							"\nPor favor cadastre o cliente!");
				}					
			}
		}
	 }
	
	public void alterarCliente(Cliente[] clientes){
		int quem = Integer.parseInt(JOptionPane.showInputDialog("CPF do cliente você deseja alterar o cadastro: "));
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] != null) {
				if(clientes[i].cpf == quem) {
					Object[] optionsAlterar = {"Nome", "Endereço", "Telefone", "Cpf", "Automóvel", "Modelo", "Km", "Estimativa Km", "Nível VIP"};
					int opAlterar = JOptionPane.showOptionDialog(null,
							"O que você deseja alterar?",
							"Borracharia JJ",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,
							optionsAlterar,
							optionsAlterar[0]);
					
					switch(opAlterar){
					case 0:
						String nomeAlterar = JOptionPane.showInputDialog("Nome: ");
						clientes[i].nome = nomeAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 1:
						String enderecoAlterar = JOptionPane.showInputDialog("Endereço: ");
						clientes[i].endereco = enderecoAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 2:
						int telefoneAlterar = Integer.parseInt(JOptionPane.showInputDialog("Telefone: "));
						clientes[i].telefone = telefoneAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 3:
						int cpfAlterar = Integer.parseInt(JOptionPane.showInputDialog("CPF: "));
						clientes[i].cpf = cpfAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 4:
						String automovelAlterar = JOptionPane.showInputDialog("Automóvel: ");
						clientes[i].automovel = automovelAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 5:
						String modeloAlterar = JOptionPane.showInputDialog("Modelo: ");
						clientes[i].modelo = modeloAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 6:
						double kmAlterar = Double.parseDouble(JOptionPane.showInputDialog("Km: "));
						clientes[i].km = kmAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 7:
						double estimativakmAlterar = Double.parseDouble(JOptionPane.showInputDialog("Estimativa Km/mês: "));
						clientes[i].estimativakm = estimativakmAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
						
					case 8:
						int nivelVIPAlterar = Integer.parseInt(JOptionPane.showInputDialog("Nível VIP: "));
						clientes[i].nivelVIP = nivelVIPAlterar;
						JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Este cliente não está cadastrado!"+
							"\nPor favor cadastre o cliente!");
				}	
			}
		}
		
	}

	public void excluirCliente(Cliente[] clientes) {
		int quem = Integer.parseInt(JOptionPane.showInputDialog("CPF do cliente você deseja EXCLUIR o cadastro: "));
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] != null) {
				if(clientes[i].cpf == quem) {
					clientes[i] = null;
					JOptionPane.showMessageDialog(null, "Cliente Excluido!");
				} else {
					JOptionPane.showMessageDialog(null, "Este cliente não está cadastrado!"+
							"\nPor favor cadastre o cliente!");
				}
			}
		}
	}

	public void obterServico(Cliente[] clientes, Servico[] servicos) {
		int clienteServico = Integer.parseInt(JOptionPane.showInputDialog("CPF do cliente: "));
		for (int i = 0; i < servicos.length; i++) {
			if(clientes[i] != null) {
				if (clienteServico == clientes[i].cpf) {
					int numeroServico = Integer.parseInt(JOptionPane.showInputDialog("Número de serviço: "));
					int continuar = 0;
					String[] tipo = new String[20];
					String[] peca = new String[20];
					do {
						Object[] itens = { "Manutenção", "Troca" };
						Object otipo = JOptionPane.showInputDialog(null,
								"Qual o tipo de serviço?",
								"Borracharia JJ",
								JOptionPane.INFORMATION_MESSAGE,
								null,
								itens,
								itens [0]);
						int nuloTipo = Servico.proxNuloPeca(tipo);
						tipo[nuloTipo] = (String) otipo;
						
						Object[] lista = {"Velas", "Pastilhas de Freio", "Motor", "Alinhamento", "Pneus", "Suspensão"};
						Object opeca = JOptionPane.showInputDialog(null,
								"Qual o serviço?",
								"Borracharia JJ",
								JOptionPane.INFORMATION_MESSAGE,
								null,
								lista,
								lista[0]);
						int nuloPeca = Servico.proxNuloPeca(peca);
						peca[nuloPeca] = (String) opeca;
						
						Object[] maisPecas = {"Sim", "Não"};
						continuar = JOptionPane.showOptionDialog(null,
								"Deseja cadastrar mais serviços?",
								"Borracharia JJ",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,
								maisPecas,
								maisPecas[0]);
					}while(continuar != 1);
					
					Object[] pagamentos = { "Crédito", "Débito", "Dinheiro" };
					Object opagamento = JOptionPane.showInputDialog(null,
							"Qual o tipo de pagamento?",
							"Borracharia JJ",
							JOptionPane.INFORMATION_MESSAGE,
							null,
							pagamentos,
							pagamentos [0]);
					String pagamento = (String) opagamento;
					
					int nulo = Servico.proxNulo(servicos);
					servicos[nulo] = new Servico (numeroServico, tipo, peca, pagamento);
					servicos[nulo].calculaPreco(servicos[nulo]);
					clientes[i].incrementaServicos(clientes[i]);
					JOptionPane.showMessageDialog(null, "Total: " + servicos[nulo].preco);
					int precisaTroco = servicos[nulo].precisaTroco(servicos[nulo]);
					if(precisaTroco == 1) {
						double pago = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor pago?"));
						servicos[nulo].calculaTroco(servicos[nulo], pago);
						JOptionPane.showMessageDialog(null, "Troco: " + servicos[nulo].troco);
					} else {
						JOptionPane.showMessageDialog(null, "Troco: " + servicos[nulo].troco);						
					}
					break;
					
				}else {
					JOptionPane.showMessageDialog(null, 
							"Cliente não cadastrado!" +
							"\nVocê deve efetuar o cadastro do cliente!");
					break; 
				}
			}
		}
	}
}