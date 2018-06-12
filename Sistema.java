package projeto_Borracharia_JJ;

public class Sistema {
	
	public static void main(String[] args) {
			
			View ic = new View ();
			Cliente[] clientes = new Cliente[20];
			Servico[] servicos = new Servico[20];
			ic.menu(clientes, servicos);
		}
}