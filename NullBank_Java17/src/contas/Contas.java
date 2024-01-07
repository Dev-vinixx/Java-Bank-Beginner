package contas;

import clientes.Clientes;

public class Contas {

	private static double dividas;
	private double saldo;
	private int agencia;
	private int numeroDaConta = 1236544;
	private static int proximoNumeroDaConta;
	private Clientes titular;
	
	public void setSaldo() {
		System.out.println(titular.getNome() + " o saldo da sua conta é: "
	+ saldo);
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public void setNumeroDaConta() {
		numeroDaConta += proximoNumeroDaConta;
		proximoNumeroDaConta ++;
		System.out.println(titular.getNome() + " o numero da sua conta é: "
		+ numeroDaConta);
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
		System.out.println(titular.getNome() + " esse é o seu saldo atual: " + saldo);
		} else if (valor >= dividas){
			saldo = valor - dividas;
			System.out.println(titular.getNome() + " você quitou suas"
					+ " dividas com o banco, esse é seu saldo atual: " + saldo);
		} else {
			dividas -= valor;
			System.out.println(titular.getNome() + " faltam: " + dividas
					+ " para você quitar suas dividas.");
		}
	}
	public boolean sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			System.out.println("saque feito com sucesso, " + titular.getNome()
			+ "seu saldo atual é de: " + saldo);
			return true;
		} else {
			System.out.println(titular.getNome() + "seu saldo atual não permite que"
					+ " faça um saque desse valor, por falvor deposite o nescessario "
					+ "para concliur o saque, faltam: " + (valor - saldo));
			return false;
		}
	}
	public boolean transferir(double valor,Contas contaDestino,String motivo) {
		if (saldo >= valor) {
			saldo -= valor;
			contaDestino.depositar(valor);
			System.out.println(titular.getNome() + " tranferencia concluida com sucesso, "
					+ "o seu saldo é de: " + saldo + ". "
			+ contaDestino.titular.getNome()
			+ " seu saldo atual é de: " + contaDestino.saldo);
			System.out.println(titular.getNome() + " -esse foi o motivo da transferencia: " + motivo);
			return true;
		} else {
			System.out.println(titular.getNome() + " seu saldo atual não permite que"
					+ " faça uma tranferencia desse valor, por falvor deposite o nescessario "
					+ "para concliur a transferencia, faltam: " + (valor - saldo));
			return false;
		}
		
	}
	public void emprestimo(double valor) {
	int porcentagemAGanhar = (int) ((valor + titular.getScore()) * 32); 
	saldo += porcentagemAGanhar / 100;

	System.out.println(titular.getNome() + " você pegou um emprestimo de: " + (porcentagemAGanhar / 2));
		System.out.println(titular.getNome() + " seu saldo atua é de: " + saldo);
	System.out.println(titular.getNome() + " o valor a se pargar ao banco é de: "
			 + (valor * (243 / 1)));
	
	}
	
	
}
