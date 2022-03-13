package post.sondaggio;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDao;
import post.sondaggio.utility.SondaggioUtility;


public class SondaggioDoppiaVotazione extends Sondaggio{

 
	private int[] conteggio = new int[2];
	public SondaggioDoppiaVotazione(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
			int numLike, int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta, int [] conteggio) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile, profilo, primaScelta, secondaScelta);
		
	}

	public void azzeraConteggio(int [] c) {
		for(int i = 0; i < 2; i++)
			c[i] = 0;
	}
	
	
	@Override
	public void aggiungiVoto(int n) {
		this.azzeraConteggio(conteggio);
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

@Override
public String toString() {
	return super.toString() + ", conteggio = " + Arrays.toString(conteggio) + "]";
}


public ArrayList<SondaggioDoppiaVotazioneDB> selectAllSDV() {
	SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
	return sdao.selectAll();
}


public boolean caricaPost(SondaggioDoppiaVotazione p) {
	SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
	SondaggioUtility u = new SondaggioUtility();
	boolean b = sdao.pubblicaSondaggio(u.convertiSDV(p));
	return b;
}


public boolean rimuoviPost(SondaggioDoppiaVotazione p) {
	SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
	SondaggioUtility u = new SondaggioUtility();
	return sdao.rimuoviSondaggio(u.convertiSDV(p));
}

public int[] getConteggio() {
	return conteggio;
}

public void setConteggio(int[] conteggio) {
	this.conteggio = conteggio;
}


@Override
public void mostraRisultati() {
	System.out.println("L'opzione " + this.getPrimaScelta() + " ha totalizzato " + this.conteggio[0] + " voti\n"
			+ "L'opzione " + this.getSecondaScelta() + " ha totalizzato " + this.conteggio[1] + " voti\n");
	
}

}
