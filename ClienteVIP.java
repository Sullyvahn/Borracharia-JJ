package projeto_Borracharia_JJ;

public class ClienteVIP extends Cliente {
	
	ClienteVIP(String nome,
			String endereco,
			int telefone,
			int cpf,
			String automovel,
			String modelo,
			double km,
			double estimativakm,
			int nivelVIPi){
		super (nome, endereco, telefone, cpf, automovel, modelo, km, estimativakm);
		nivelVIP = nivelVIPi;
	}
	
	public void calculaDesconto(Cliente cliente) {
		if(cliente.nivelVIP == 1){
			cliente.desconto = 0.05;
		} else if(cliente.nivelVIP == 2){
			cliente.desconto = 0.1;
		} else if(cliente.nivelVIP == 3){
			cliente.desconto = 0.15;
		}
	}
	
	public int tipoDeCliente(Cliente[] clientes) {
		return 1;
	}
}