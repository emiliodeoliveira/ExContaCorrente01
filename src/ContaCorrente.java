import java.util.Random;

public class ContaCorrente {
	String nomeCorrentista;
	int numeroConta;
	double saldo = 0;

	protected String getNomeCorrentista() {
		return nomeCorrentista;
	}

	protected void setNomeCorrentista(String nomeCorrentista) {
		this.nomeCorrentista = nomeCorrentista;
	}

	protected ContaCorrente() {
		setNomeCorrentista(geradorNomes());
		setNumeroConta(geradorNumeroConta());
	}
	protected void deposito(double valor) {
		saldo += valor;
	}

	protected void retirada(double valor) {
		if (saldo - valor > 0) {
			saldo -= valor;
		}
		else {
			System.out.println("Saldo insuficiente!");
		}
	}	
	protected int getNumeroConta() {
		return numeroConta;
	}


	protected void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	protected double getSaldo() {
		return saldo;
	}


	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected static int geradorNumeroConta() {
		Random ran = new Random();
		int[] simbolos = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };		
		int tamanhoNum  = 6;
		int b = 0;
		for (int i = 0; i < tamanhoNum; i++) {
			int a = ran.nextInt(simbolos.length);
			b += simbolos[a];
		}
		return b;
	}

	protected static String geradorNomes() {
		Random ran = new Random();
		String[] simbolos = { "Ana", "André", "Bruno", "Carlos", "Cristina","Douglas", "Débora"};		
		return simbolos[new Random().nextInt(simbolos.length)];
	}

	@Override
	public String toString() {
		return "[Conta corrente: " + numeroConta + ", Nome: "+ nomeCorrentista+", Saldo: R$ " + saldo + "]";
	}

}
