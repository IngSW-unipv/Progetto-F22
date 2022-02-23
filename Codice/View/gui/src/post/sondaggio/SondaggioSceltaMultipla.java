package post.sondaggio;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class SondaggioSceltaMultipla extends Sondaggio{

	public SondaggioSceltaMultipla(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
			int numLike, int numDislike, boolean visibile, boolean isStory, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta, String idSondaggio, String terzaScelta, String quartaScelta, int [] conteggio) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, isStory, condivisibile,	profilo, primaScelta, secondaScelta, idSondaggio);
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
		this.azzeraConteggio(conteggio);
	}

	private String terzaScelta;
	private String quartaScelta;
	private int [] conteggio = new int [4];
	
	public void azzeraConteggio(int [] conteggio) {
		for(int i = 0; i < 3; i++)
			conteggio[i] = 0;
	}
	
	public String getTerzaScelta() {
		return terzaScelta;
	}
	public void setTerzaScelta(String terzaScelta) {
		this.terzaScelta = terzaScelta;
	}
	public String getQuartaScelta() {
		return quartaScelta;
	}
	public void setQuartaScelta(String quartaScelta) {
		this.quartaScelta = quartaScelta;
	}

	public int[] getConteggio() {
		return conteggio;
	}

	public void setConteggio(int[] conteggio) {
		this.conteggio = conteggio;
	}

	@Override
	public void aggiungiVoto(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println("Inserisci il numero corrispondente alla tua scelta : \n" + "1 = " + this.getPrimaScelta() + "\n" + "2 = " + this.getSecondaScelta() + "\n" + "3 = " + this.getTerzaScelta() + "\n" + "4 = " + this.getQuartaScelta());
			    Scanner scanner = new Scanner(System.in);
		        int a = scanner.nextInt(); 
		        switch(a) {
		        case 1 : conteggio[0] += 1;
		        	     break;
		        case 2 : 
		        	     conteggio[1] += 1;
		                 break;
		        case 3 : 
	        	     conteggio[2] += 1;
	                 break;
		        case 4 : 
	        	     conteggio[3] += 1;
	                 break;
	                 
		        default: System.out.println("Voto non valido, Scegli un valore esistente");
		        }
		        
		        if(i == (n - 1)) {
		        	scanner.close();
		        }
			}
	}

	@Override
	public void mostraRisultati() {
		System.out.println("L'opzione " + this.getPrimaScelta() + " ha totalizzato " + this.conteggio[0] + " voti\n"
				+ "L'opzione " + this.getSecondaScelta() + " ha totalizzato " + this.conteggio[1] + " voti\n"
				+ "L'opzione " + this.getTerzaScelta() + " ha totalizzato " + this.conteggio[2] + " voti\n"
				+ "L'opzione " + this.getQuartaScelta() + " ha totalizzato " + this.conteggio[3] + " voti\n");
	}
}
