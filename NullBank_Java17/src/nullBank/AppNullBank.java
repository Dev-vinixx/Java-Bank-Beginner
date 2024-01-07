package nullBank;
import clientes.Clientes;
import contas.Contas;

public class AppNullBank {

	public static void main(String[] args) {
		Clientes Vinicius = new Clientes();
		Contas ContaDoVinicius = new Contas();
		ContaDoVinicius.setTitutal(Vinicius);
		Vinicius.setNome("Vinicius Eduardo");
		Vinicius.setRenda(134342500);
		ContaDoVinicius.setSaldo();
		ContaDoVinicius.setNumeroDaConta();
		ContaDoVinicius.depositar(400000);
		ContaDoVinicius.setSaldo();
		Clientes Julia = new Clientes();
		Contas ContaDaJulia = new Contas();
		ContaDaJulia.setTitutal(Julia);
		Julia.setNome("Julia Wahbeh");
		Julia.setRenda(1500);
		ContaDaJulia.setSaldo();
		ContaDaJulia.setNumeroDaConta();
		ContaDaJulia.depositar(1000);
		ContaDaJulia.setSaldo();
		Clientes janiel = new Clientes();
		Contas ContaDoJaniel = new Contas();
		ContaDoJaniel.setTitutal(janiel);
		janiel.setNome("Janiel Fonseca");
		janiel.setRenda(1500);
		ContaDoJaniel.setSaldo();
		ContaDoJaniel.setNumeroDaConta();
		ContaDoJaniel.depositar(3000);
		ContaDoJaniel.setSaldo();
		Clientes Victor = new Clientes();
		Contas ContaDoVictor = new Contas();
		ContaDoVictor.setTitutal(Victor);
		Victor.setNome("Victor Santos");
		Victor.setRenda(1500);
		ContaDoVictor.setSaldo();
		ContaDoVictor.setNumeroDaConta();
		ContaDoVictor.depositar(5000);
		ContaDoVictor.setSaldo();
		ContaDoVictor.transferir(5000, ContaDoVinicius, "paguei pq tava te devendo");
		ContaDoJaniel.transferir(3000, ContaDoVinicius, "esse foi pelo mouse");
		ContaDoVinicius.emprestimo(2333);
	    ContaDoVinicius.depositar(233);
	}
}
 