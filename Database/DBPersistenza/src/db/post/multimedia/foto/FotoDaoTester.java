package db.post.multimedia.foto;

//import post.multimedia.foto.Foto;


// import convertitore.ConvertitoreFacade;


public class FotoDaoTester {

	public static void main(String [] args) {
		FotoDao fdao = new FotoDao();
		FotoDB f = new FotoDB("F00", null, null, "Il mio primo post", 0, 0, false, false, "DV999", 0, "degufg", false, false);
		FotoDB f1 = new FotoDB("F00", null, null, null, 0, 0, false, false, null, 0, null, false, false);
	//	ConvertitoreFacade fc = ConvertitoreFacade.getIstance();
		/*System.out.println(fdao.pubblicaFoto(fc.converti(f)));
		System.out.println(fdao.rimuoviFoto(fc.converti(f)));
		
		ArrayList<FotoDB> fres = fdao.cercaFoto("F00");
		
		for(FotoDB fdb : fres) {
			System.out.println(fdb.toString());
		}*/
		
		FotoDB ft = (FotoDB) fdao.cercaPost(f);
		System.out.println(ft.toString());
	}
}
