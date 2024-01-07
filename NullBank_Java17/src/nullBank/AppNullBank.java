package nullBank;


import clientes.Clientes;
import contas.Contas;

public class AppNullBank {

	public static void main(String[] args) {
		Clientes Vinicius = new Clientes();
		Contas ContaDoVinicius = new Contas();
		ContaDoVinicius.setTitutal(Vinicius);
		Vinicius.setNome("Vinicius Eduardo");
		Vinicius.setScore(300);
		Vinicius.setRenda(1500);
		Clientes Junior = new Clientes();
		Contas ContaDoJunior = new Contas();
		ContaDoJunior.setTitutal(Junior);
		Junior.setNome("Victor Junior");
		Junior.setScore(150);
		Junior.setRenda(13500);
	    ContaDoVinicius.depositar(1500);
	    ContaDoVinicius.girarUmNumero(5, 1500);
	    ContaDoVinicius.transferir(2000, ContaDoJunior, "Essa foi o tigrinho que pagou.");
	}
}
 