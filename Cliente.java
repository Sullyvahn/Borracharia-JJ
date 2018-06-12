package projeto_Borracharia_JJ;

public class Cliente {
	public String nome;
	public String endereco;
	public int telefone;
	public int cpf;
	public String automovel;
	public String modelo;
	public double km;
	public double estimativakm;
	public double mesesRevisao;
	public double desconto = 0;
	public int nivelVIP = 0;
	public int qttServicos = 0;
	
	Cliente (String nome,
		String endereco,
		int telefone,
		int cpf,
		String automovel,
		String modelo,
		double km,
		double estimativakm){
		
			this.nome = nome;
			this.endereco = endereco;
			this.telefone = telefone;
			this.cpf = cpf;
			this.automovel = automovel;
			this.modelo = modelo;
			this.km = km;
			this.estimativakm = estimativakm;
			this.desconto = 0;
	}
	
	
	public static int proxNulo(Cliente[] clientes){
		for (int i = 0; i < clientes.length; i++){
			if (clientes[i] == null){
				return i;
			}
		}
		return 20;
	}
	

	public void calculaDesconto (Cliente cliente) {
		
	}
	
	
	public void calculoRevisao(Cliente cliente){
			double estimativaKMi = cliente.estimativakm;
			double mesesRevisaoi = 10000/estimativaKMi;;
			cliente.mesesRevisao = mesesRevisaoi;
	}

	public int tipoDeCliente(Cliente[] clientes) {
		return 0;
	}
	
	public void incrementaServicos(Cliente cliente) {
		cliente.qttServicos++;
	}
}