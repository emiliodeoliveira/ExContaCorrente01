import java.util.Random;
/**
 * 
 * @author Emilio de Oliveira
 *
 */

public class CadastroDeContas {
	static ContaCorrente[] vConta = new ContaCorrente[10];

	public static void main(String[] args) {
		ContaCorrente conta = new ContaCorrente();
		while (true) {
			switch (Interfaces.readString(menu()).charAt(0)) {
			case '1':
				cadastrarConta();
				break;
			case '2':				
				efetuarDeposito();
				break;
			case '3':
				efetuarRetirada();
				break;
			case '4':
				listarContas();
				break;
			case '5':
				maiorSaldo();
				break;
			case '6':
				getSaldoTotal();
				break;
			case '7':
				System.exit(0);
				break;
			}
		}		
	}

	protected static void efetuarDeposito() {
		int numConta = Interfaces.readInteger("Digite o número da conta: ");
		int indiceConta = procuraConta(numConta);
		if (indiceConta >= 0) {
			int valorDeposito = Interfaces.readInteger("Digite o valor a ser depositado: R$");
			vConta[indiceConta].deposito(valorDeposito);
		} if (indiceConta < 0)  {
			System.out.println("Conta inexistente!");
		}	

	}

	protected static void efetuarRetirada() {
		int numConta = Interfaces.readInteger("Digite o número da conta: ");
		int indiceConta = procuraConta(numConta);
		if (indiceConta >= 0) {
			int valorRetirada = Interfaces.readInteger("Digite o valor a ser retirado: R$");
			vConta[indiceConta].retirada(valorRetirada);
		} if (indiceConta < 0) {
			System.out.println("Conta inexistente!");
		}		
	}

	protected static void listarContas() {
		System.out.println("Contas cadastradas: ");
		if (vConta[0] != null) {			
			for (int a = 0; a < vConta.length; a++) {
				if (vConta[a] != null) {
					System.out.println(vConta[a]);
				}
			}			
		}	else {
			System.out.println("Não existem contas cadastradas!");
		}
	}

	protected static void cadastrarConta() {
		for (int a = 0; a < vConta.length; a++) {
			if (vConta[a] == null) {
				vConta[a] = new ContaCorrente();
				System.out.println("A seguinte conta foi criada: \n"+vConta[a]);
				return;				
			}			
		}		
	}

	protected ContaCorrente getConta(int nroConta) {
		return null;
	}

	protected int conta(double noMinimo) {
		return 0;
	}

	protected static void getSaldoTotal() {
		double saldoTotal = 0;
		for(int k=0 ; k<vConta.length ; k++)
			if (vConta[k] != null)
				saldoTotal += vConta[k].getSaldo();
			else break;
		System.out.println("O saldo total das contas é de R$: "+saldoTotal);
	}

	protected static void maiorSaldo() {
		ContaCorrente contaMaior = null;
		double a = 0, maior = 0, indMaior = 0;
		for (int i = 0; i < vConta.length; i++){
			if (vConta[i] != null) {
				a = vConta[i].getSaldo();
				if (a > maior) {
					contaMaior = vConta[i];
				}
			}
		}
		if (contaMaior != null)
			System.out.println("A conta com maior salário é: \n"+contaMaior.saldo);
		else System.out.println("Todas as contas estão sem saldo");
	}

	protected static int procuraConta(int nro){
		for (int index = 0; index < vConta.length; index++)		{
			if (vConta[index].getNumeroConta() == nro) {
				return index;  
			}
		}		
		return -1 ;
	}

	protected static String menu() {
		String menu = "";
		menu += "\nSistema financeiro:";
		menu += "\n  1 - Cadastrar conta.";
		menu += "\n  2 - Efetuar depósito.";
		menu += "\n  3 - Efetuar retirada.";
		menu += "\n  4 - Listar contas.";
		menu += "\n  5 - Ver conta com maior saldo.";
		menu += "\n  6 - ver saldo total das contas.";
		menu += "\n  7 - Sair.";
		menu += "\nEscolha: ";
		return menu;
	}
}
