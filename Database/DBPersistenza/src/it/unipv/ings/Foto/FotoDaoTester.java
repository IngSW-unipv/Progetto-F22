package it.unipv.ings.Foto;

public class FotoDaoTester {

	public static void main(String [] args) {
		FotoDao fdao = new FotoDao();
		FotoDB f = new FotoDB("F00", null, "P00", false);
		//System.out.println(fdao.pubblicaFoto(f));
		System.out.println(fdao.rimuoviFoto(f));
	}
}
