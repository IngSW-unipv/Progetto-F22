package Sistema;

import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AccountGiaEsistente;
import profilo.exception.ChangeDefaultPassword;
import profilo.exception.PswOmailErrati;

public class TestSistema {

	public static void main(String [] args) {
		Sistema s = new Sistema();

		Profilo p = new Profilo("francesco.ardizzoni@gmail.com", "francy99");
		Foto f = new Foto("F00", null, false, null, null, false);
        Video v = new Video("V00", null, false, null, null, 0);
		try {
			System.out.println(s.signIn("DV999", "Davide99", "Marmellata"));
		} catch (AccountGiaEsistente | ChangeDefaultPassword | AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			s.login("francesco.ardizzoni@gmail.com", "francy99");
		} catch (ChangeDefaultPassword | AccountDoesNotExist | PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			s.login("DV999", "Marmellata");
		} catch (ChangeDefaultPassword | AccountDoesNotExist | PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Profilo p2 = p.cercaProfilo(p);
			System.out.println(p2.getFotoProfilo());
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		s.pubblicaTesto("testo di prova", false, null, null, null);
	}
}
