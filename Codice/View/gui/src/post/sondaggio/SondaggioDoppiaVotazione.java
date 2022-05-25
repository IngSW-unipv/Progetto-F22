package post.sondaggio;

import java.util.Arrays;
import java.util.Scanner;

import post.Post;
import post.enumeration.TipoPost;


public class SondaggioDoppiaVotazione extends Sondaggio{

 
	private int[] conteggio = new int[2];
	public SondaggioDoppiaVotazione(String idPost, String descrizione, 
			boolean visibile, boolean condivisibile, String profilo, String primaScelta, String secondaScelta, int [] conteggio) {
		super(idPost,descrizione, visibile, condivisibile, profilo, primaScelta, secondaScelta);
		this.conteggio = conteggio;
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

@Override
public TipoPost getTipo() {
	return TipoPost.SONDAGGIODOPPIAVOTAZIONE;
}

@Override
public Post inserisciCaratteristiche(Post p) {
	p = new SondaggioDoppiaVotazione(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.isCondivisibile(), p.getProfilo(), this.getPrimaScelta(), this.getSecondaScelta(), this.getConteggio());
	return p;
}

}
