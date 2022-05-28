package db.post.multimedia.foto;


public class FotoDaoTester {

	public static void main(String [] args) {
		FotoDao fdao = new FotoDao();
		FotoDB f = new FotoDB("F00", null, null, "Il mio primo post", 0, 0, false, "DV999", 0, "degufg", false, false);
	
		
		FotoDB ft = (FotoDB) fdao.cercaPost(f);
		System.out.println(ft.toString());
	}
}
