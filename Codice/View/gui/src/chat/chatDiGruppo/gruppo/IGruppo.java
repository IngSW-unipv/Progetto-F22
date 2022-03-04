package chat.chatDiGruppo.gruppo;

import java.util.ArrayList;

public interface IGruppo {

	boolean caricaGruppo(Gruppo g);
	boolean eliminaGruppo(Gruppo g);
	
	//Con questo metodo posso modificare i 6 partecipanti di un gruppo.
	//Se voglio aggiungere un profilo creo un gruppo che ha ad esempio come idProfilo1
	//un certo id che voglio aggiungere.
	//Se voglio rimuovere un partecipante passo al metodo un Gruppo g che ha come 
	//i esimo idProfilo (L'id profilo che voglio rimuovere) uguale a null
	boolean gestisciPartecipanti(Gruppo g);
	
	public ArrayList<Gruppo> cercaGruppo(Gruppo g);
	public ArrayList<Gruppo> selectAll();
	
}
