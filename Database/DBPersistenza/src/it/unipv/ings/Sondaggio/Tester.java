package it.unipv.ings.Sondaggio;

public class Tester {

	public static void main(String[] args) {
		SondaggioDao sdao = new SondaggioDao();
		SondaggioDB d = new SondaggioDB("SD00", null, null, null, null,"P00");
		System.out.println(sdao.pubblicaSondaggio(d));
	}
}
