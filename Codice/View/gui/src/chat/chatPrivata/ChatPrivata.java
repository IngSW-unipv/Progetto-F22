package chat.chatPrivata;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import chat.Chat;
import db.messaggioPrivato.MessaggioPrivatoDao;
import profilo.Profilo;

public class ChatPrivata extends Chat {
	
	public ChatPrivata(Profilo profiloAttivo) {
		super(profiloAttivo);
	}

		public ArrayList<MessaggioPrivato> selectAllNomeProfilo(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAllNomeProfilo(m);
	}
	
	public boolean inserisciChiavi(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		boolean b;
		b = mdao.inserisciChiavi(m);
		return b;
	}

	@Override
	public ArrayList<Messaggio> selectAll() {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAll();
	
	}
	
	@Override
	public ArrayList<Messaggio> cercaMessaggio(Messaggio m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.cercaMessaggioPrivato(m);
	}
	@Override
	public void ottieniMessaggio(Messaggio m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		mdao.ottieniMessaggio(m);
	}

	@Override
	public boolean caricaMessaggio(Messaggio m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		boolean b;
		b = mdao.scriviMessaggioPrivato(m);
		return b;
	}

	@Override
	public boolean eliminaMessaggio(Messaggio m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		boolean b;
		b = mdao.rimuoviMessaggioPrivato(m);
		return b;
	}
	

	@Override
	public void leggiTuttiMessaggi() {
		Timer timer = new Timer();
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();   
		timer.schedule( new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<Messaggio> show = mdao.selectAll();
               for(Messaggio msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
	}

	//Legge tutti i messaggi ricevuti ogni minuto da un profilo precisato.
	//Dopo 5 minuti smette di farlo e si stoppa
	
	public void leggiMessaggiPrivati(MessaggioPrivato m) {
		Timer timer = new Timer();
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();   
		timer.schedule( new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<MessaggioPrivato> show = mdao.selectAllNomeProfilo(m);
               for(Messaggio msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
	}
	}


	


