package projeto_Borracharia_JJ;

public class Servico {
	public int numeroServico;
	public String[] tipo = new String[20];
	public String[] peca = new String[20];
	public String pagamento;
	public double preco;
	public int qttPeca;
	public double troco = 0;
	public int tempo;
	
	Servico(int numeroServico,
			String[] tipo,
			String[] peca,
			String pagamento){
		this.numeroServico = numeroServico;		
		this.tipo = tipo;
		this.peca = peca;
		this.pagamento = pagamento;
	}
	
	public static int proxNulo(Servico[] servicos){
		for (int i = 0; i < servicos.length; i++){
			if (servicos[i] == null){
				return i;
			}
		}
		return 20;
	}
	
	public static int proxNuloPeca(String[] peca) {
		for (int i = 0; i < peca.length; i++) {
			if(peca[i] == null) {
				return i;
			}
		}
		return 20;
	}
	
	public void calculaPreco(Servico servico) {
		double precoFinal=0;
		for (int i = 0; i < peca.length; i++) {
			if(servico != null) {
				if(servico.peca[i] == "Velas") {
					precoFinal+=40;
				} else if(servico.peca[i] == "Pastilhas de Freio") {
					precoFinal+=80;
				} else if(servico.peca[i] == "Motor") {
					precoFinal+= 5000;
				} else if(servico.peca[i] == "Alinhamento") {
					precoFinal+=90;
				} else if(servico.peca[i] == "Pneus") {
					precoFinal+=200;
				} else if(servico.peca[i] == "Suspensão") {
					precoFinal+=150;
				}
				if(servico.tipo[i] == "Troca") {
					precoFinal*=2;
				}
			}
		}
		servico.preco = precoFinal;
	}
	
	public int precisaTroco(Servico servico) {
		if(servico.pagamento == "Dinheiro") {
			return 1;
		} else {
			return 0;
		}
	}
	
	public void calculaTroco(Servico servico, double pago) {
		double calculoTroco=0;
		calculoTroco = (pago - servico.preco);
		servico.troco = calculoTroco;
	}
	
	public void calculaTempo(Servico servico) {
		int tempoFinal=0;
		for (int i = 0; i < peca.length; i++) {
			if(servico != null) {
				if(servico.peca[i] == "Velas") {
					tempoFinal+=20;
				} else if(servico.peca[i] == "Pastilhas de Freio" || servico.peca[i] == "Pneus" || servico.peca[i] == "Suspensão") {
					tempoFinal+=40;
				} else if(servico.peca[i] == "Motor") {
					tempoFinal+= 60;
				} else if(servico.peca[i] == "Alinhamento") {
					tempoFinal+=90;
				
				}
				if(servico.tipo[i] == "Manutenção") {
					tempoFinal*=2;
				}
			}
		}
		servico.tempo = tempoFinal;
	}
}