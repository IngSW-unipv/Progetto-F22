package db.foto;

import post.multimedia.foto.Foto;

public class FotoDaoTester {

	public static void main(String [] args) {
		FotoDao fdao = new FotoDao();
		Foto f = new Foto("F00", null, null, null, 0, 0, false, false, null, 0, null, false, false);
		System.out.println(fdao.pubblicaFoto(f));
		System.out.println(fdao.rimuoviFoto(f));
	}
}
