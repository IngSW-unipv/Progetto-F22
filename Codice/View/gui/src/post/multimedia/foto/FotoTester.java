package post.multimedia.foto;

public class FotoTester {

	public static void main(String[] args) {
		Foto f = new Foto("P00", null, null, null, 0, 0, false, false, null, 0, null, false, "F00");
        UtilityFoto u = new UtilityFoto();
        System.out.println(f.pubblicaFoto(u.convertiToFotoDB(f)));
        //System.out.println(f.rimuoviFoto(u.convertiToFotoDB(f)));
	}

}
