package db.foto;

import post.multimedia.foto.Foto;
import post.multimedia.foto.utility.FotoUtility;

public class FotoDaoTester {

	public static void main(String [] args) {
		FotoDao fdao = new FotoDao();
        FotoUtility u = new FotoUtility();
		Foto f = new Foto("F00", null, null, null, 0, 0, false, false, null, 0, null, false, false);
		System.out.println(fdao.pubblicaFoto(u.converti(f)));
		System.out.println(fdao.rimuoviFoto(u.converti(f)));
	}
}
