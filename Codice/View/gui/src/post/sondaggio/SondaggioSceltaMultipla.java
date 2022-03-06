package post.sondaggio;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDao;
import post.Post;

public class SondaggioSceltaMultipla extends Sondaggio{

	public SondaggioSceltaMultipla(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
			int numLike, int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile,	profilo, primaScelta, secondaScelta);
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
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
		this.azzeraConteggio(conteggio);
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

	@Override
	public ArrayList<Post> selectAll() {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		return sdao.selectAll();
	}

	@Override
	public boolean caricaPost(Post p) {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		boolean b = sdao.pubblicaSondaggio(p);
		sdao.aggiungiScelte(p, this.getPrimaScelta(), this.getSecondaScelta(), this.getTerzaScelta(), this.getQuartaScelta());
		return b;
	}

	@Override
	public boolean rimuoviPost(Post p) {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		return sdao.rimuoviSondaggio(p);
	}

	@Override
	public String toString() {
		return super.toString() + ", terzaScelta = " + terzaScelta + ", quartaScelta = " + quartaScelta + ", conteggio = "
				+ Arrays.toString(conteggio) + "]";
	}
}
