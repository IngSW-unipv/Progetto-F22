package post.sondaggio;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import it.unipv.ings.Sondaggio.SondaggioDB;
import it.unipv.ings.Sondaggio.SondaggioDao;

public class SondaggioDoppiaVotazione extends Sondaggio{

 
	private int[] conteggio = new int[2];
	public SondaggioDoppiaVotazione(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
			int numLike, int numDislike, boolean visibile, boolean isStory, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta, String idSondaggio, int [] conteggio) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, isStory, condivisibile, profilo, primaScelta, secondaScelta, idSondaggio);
		this.azzeraConteggio(conteggio);
	}

	public void azzeraConteggio(int [] c) {
		for(int i = 0; i < 2; i++)
			c[i] = 0;
	}
	
	
	@Override
	public void aggiungiVoto(int n) {
		for(int i = 0; i < n; i++) {
		System.out.println("Inserisci il numero corrispondente alla tua scelta : \n" + "1 = " + this.getPrimaScelta() + "\n" + "2 = " + this.getSecondaScelta());
		    Scanner scanner = new Scanner(System.in);
	        int a = scanner.nextInt(); 
	        switch(a) {
	        case 1 : conteggio[0] += 1;
	        	     break;
	        case 2 : 
	        	     conteggio[1] += 1;
	                 break;
	        default: System.out.println("Voto non valido, Scegli un valore esistente");
	        }
	        
	        if(i == (n - 1)) {
	        	scanner.close();
	        }
		}
		
	}


	public boolean pubblicaSondaggio(SondaggioDB s) {
		SondaggioDao sdao = new SondaggioDao();
		boolean b;
		b = sdao.pubblicaSondaggio(s);
		return b;
	}


	public boolean rimuoviSondaggio(SondaggioDB s) {
		SondaggioDao sdao = new SondaggioDao();
		boolean b;
		b = sdao.rimuoviSondaggio(s);
		return b;
	}

	@Override
	public void mostraRisultati() {
		System.out.println("L'opzione " + this.getPrimaScelta() + " ha totalizzato " + this.conteggio[0] + " voti\n"
				+ "L'opzione " + this.getSecondaScelta() + " ha totalizzato " + this.conteggio[1] + " voti\n");
		
	}

}
