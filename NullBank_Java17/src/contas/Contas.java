package contas;

import java.util.Random;

import clientes.Clientes;

public class Contas {

	private double dividas;
	private double saldo;
	private int agencia;
	private int numeroDaConta;
	private static int proximoNumeroDaConta;
	private Clientes titular;

	public void getSaldo() {
		System.out.println(titular.getNome() + " o saldo da sua conta é: " + saldo);
	}

	public void getAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setNumeroDaConta() {
		numeroDaConta += proximoNumeroDaConta;
		proximoNumeroDaConta++;
		System.out.println(numeroDaConta);
	}

	public Clientes getTitutal() {
		return titular;
	}

	public void setTitutal(Clientes titular) {
		this.titular = titular;
	}

	public void depositar(double valor) {
		if (dividas == 0) {
			saldo += valor;
			System.out.println(titular.getNome() + " Seu deposito foi concluido seu saldo atual é de: " + saldo);
		} else if (valor >= dividas) {
			System.out.println(titular.getNome() + " Está conta está temporariamente inativa "
					+ "para ativar a conta novamente page o seu imprestimo.");
		}
	}

	public boolean sacar(double valor) {
		if (saldo >= valor && dividas <= 99999) {
			saldo -= valor;
			System.out.println(titular.getNome() + " O saque feito com sucesso, " + "seu saldo atual é de: " + saldo);
			return true;
		} else if (dividas >= 99999) {
			System.out.println(titular.getNome() + " Está conta está temporariamente inativa "
					+ "para ativar a conta novamente page o seu imprestimo.");
			return false;
		} else {
			System.out.println(titular.getNome() + "seu saldo atual não permite que"
					+ " faça um saque desse valor, por falvor deposite o nescessario "
					+ "para concliur o saque, faltam: " + (valor - saldo));
			return false;
		}
	}

	public boolean transferir(double valor, Contas contaDestino, String motivo) {
		if (saldo >= valor && dividas <= 99999) {
			saldo -= valor;
			contaDestino.depositar(valor);
			System.out.println(titular.getNome() + " Tranferencia concluida com sucesso, " + "o seu saldo é de: "
					+ saldo + ". " + contaDestino.titular.getNome() + " seu saldo atual é de: " + contaDestino.saldo);
			System.out.println(titular.getNome() + " Esse foi o motivo da transferencia: " + motivo);
			return true;
		} else if (dividas >= 99999) {
			System.out.println(titular.getNome() + " Está conta está temporariamente inativa "
					+ "para ativar a conta novamente page o seu imprestimo.");
			return false;
		} else {
			System.out.println(titular.getNome() + " Seu saldo atual não permite que"
					+ " faça uma tranferencia desse valor, por falvor deposite o nescessario "
					+ "para concliur a transferencia, faltam: " + (valor - saldo));
			return false;
		}

	}

	public void emprestimo(double valor) {
		if (dividas <= 99999 && valor > 0) {
			int porcentagemAGanhar = (int) ((valor + titular.getScore()) * 32);
			saldo += (int) porcentagemAGanhar / 70;

			System.out.println(titular.getNome() + " Você pegou um emprestimo de: " + (porcentagemAGanhar / 70));
			System.out.println(titular.getNome() + " Seu saldo atua é de: " + saldo);
			System.out.println(titular.getNome() + " O valor a se pargar ao banco é de: "
					+ ( (int) (valor + titular.getScore()) * 32.51) / 70);
			dividas += (int) (((valor + titular.getScore()) * 32.51)) / 70;
		} else if (dividas >= 99999) {
			System.out.println(titular.getNome() + " Está conta está temporariamente inativa "
					+ "para ativar a conta novamente page o seu imprestimo.");
		} else {
			System.out.println("Este valor é invalido por favor escolha uma valor maior que 0.");
		}
	}

	public void getDividas() {
		System.out.println(titular.getNome() + " Esse é o valor a pagar por seu imprestimo: " + dividas);
	}

	public void girarUmNumero(int seuNumero, double valor) {
		Random random = new Random();
		int numeroAleatorio = random.nextInt(6);
		if ((seuNumero <= 5 && seuNumero >= 0) && saldo >= valor) {
			if (numeroAleatorio == seuNumero) {
				System.out.println("Opa você ganhou!! seu premio foi de: " + valor * seuNumero);
				saldo += valor * seuNumero;
				System.out.println(titular.getNome() + "Seu saldo atual" + " é de: " + saldo);
			} else if (saldo < valor) {

				System.out.println("Não foi dessa vez pelo visto voce perdeu tudo!!");
				saldo -= saldo;

				System.out.println(titular.getNome() + "Seu saldo atual" + " é de: " + saldo);
			} else {
				System.out.println("Não foi dessa vez pelo visto voce perdeu: " + valor);
				saldo -= valor;

				System.out.println(titular.getNome() + "Seu saldo atual" + " é de: " + saldo);
			}
		} else if (saldo < valor) {
			System.out.println("Só aposte oq você tem na conta.");
		} else {
			System.out.println("Só aceitamos numeros de 0 a 5 ! por favor tente novamente.");
		}
	}
	
	public void pagarDividas(double valor) {
		if (saldo >= dividas && saldo >= valor && valor <= dividas) {
			dividas -= valor;
			System.out.println(titular.getNome() + " Obrigado por pagar o seu imprestimo fique avontade para solicitar um emprestimo novamente.");
		} else if (saldo >= valor) {
			dividas -= valor;
			System.out.println(titular.getNome() + " Obrigado por pagar uma parcela do"
					+ " seu imprestimo fique avontade para levantar o resto do dinheiro.");
		} else if (saldo < valor){
			System.out.println("Voce não tem esse valor em sua conta por favor não coloque mais do que você tem em seu saldo");
		}else {
			System.out.println("Esse valor é maior que o seu emprestimo então tente novamente mas agora conforme foi o seu emprestimo");
		}
	}
	
}
