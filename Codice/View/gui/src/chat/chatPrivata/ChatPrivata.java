package chat.chatPrivata;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.MessaggioPrivato;
import it.unipv.ings.MessaggioPrivato.MessaggioPrivatoDao;

public class ChatPrivata implements IChatPrivata{

	@Override
	public boolean scriviMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		boolean b;
		b = mdao.scriviMessaggioPrivato(m);
		return b;
	}

	@Override
	public boolean eliminaMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		boolean b;
		b = mdao.rimuoviMessaggioPrivato(m);
		return b;
	}

	@Override
	public ArrayList<MessaggioPrivato> cercaMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.cercaMessaggioPrivato(m);
	}

	@Override
	public ArrayList<MessaggioPrivato> selectAll() {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAll();
	
	}

	@Override
	public ArrayList<MessaggioPrivato> selectAllNomeProfilo(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAllNomeProfilo(m);
	}

	@Override
	public void selectAllRipetuto() {
		Timer timer = new Timer();
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();   
		timer.schedule( new TimerTask() {
		    public void run() {
               ArrayList<MessaggioPrivato> show = mdao.selectAll();
               for(MessaggioPrivato msg : show)
            	   System.out.println(msg.toString());
		    }
		 }, 0, 300 * 1000);
		}
	}

	


