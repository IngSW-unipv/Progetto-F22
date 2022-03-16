package db.foto;

import post.multimedia.foto.Foto;

import java.util.ArrayList;

import convertitore.fotoUtility.FotoUtility;


public class FotoDaoTester {

	public static void main(String [] args) {
		FotoDao fdao = new FotoDao();
		Foto f = new Foto("F00", null, null, null, false, false, null, null, false);
		System.out.println(fdao.pubblicaFoto(FotoUtility.convertiAFotoDB(f)));
		//System.out.println(fdao.rimuoviFoto(FotoUtility.convertiAFotoDB(f)));
		
		ArrayList<FotoDB> fres = fdao.cercaFoto("F00");
		
		for(FotoDB fdb : fres) {
			System.out.println(fdb.toString());
		}
	}
}
