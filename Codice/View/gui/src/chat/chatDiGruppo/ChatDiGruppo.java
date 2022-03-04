package chat.chatDiGruppo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import chat.Chat;
import it.unipv.ings.messaggioDiGruppo.MessaggioDiGruppoDao;
import profilo.Profilo;


public class ChatDiGruppo extends Chat{

	public ChatDiGruppo(Profilo profiloAttivo) {
		super(profiloAttivo);
	}

	@Override
	public ArrayList<Messaggio> selectAll() {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAll();
	}

	@Override
	public ArrayList<Messaggio> cercaMessaggio(Messaggio m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.cercaMessaggioDiGruppo(m);
	}

	@Override
	public void ottieniMessaggio(Messaggio m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		mdao.ottieniTesto(m);
		
	}

	@Override
	public boolean caricaMessaggio(Messaggio m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		boolean b;
		b = mdao.scriviMessaggioDiGruppo(m);
		return b;
	}

	@Override
	public boolean eliminaMessaggio(Messaggio m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		boolean b;
		b = mdao.rimuoviMessaggioDiGruppo(m);
		return b;
	}

	@Override
	public void leggiTuttiMessaggi() {
		
			Timer timer = new Timer();
			MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();   
			timer.schedule(new TimerTask() {
				int i = 0;
			    public void run() {
			       
	               ArrayList<Messaggio> show = gdao.selectAll();
	               for(Messaggio msg : show)
	            	   System.out.println(msg.toString());
	                   i++;
	                   if(i == 5)
	            	      timer.cancel();
			   
			    }
			 }, 0, 60 * 1000);
	}

	public ArrayList<MessaggioDiGruppo> selectAllIdGruppo(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAllIdGruppo(m);
	}

	
	public boolean inserisciChiavi(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		boolean b;
		b = mdao.rimuoviMessaggioDiGruppo(m);
		return b;
	}

	//Legge tutti i messaggi ricevuti ogni minuto da un profilo precisato.
	//Dopo 5 minuti smette di farlo e si stoppa
		
	public void leggiMessaggiDiGruppo(MessaggioDiGruppo m) {
		
		Timer timer = new Timer();
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();   
		timer.schedule(new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<MessaggioDiGruppo> show = gdao.selectAllIdGruppo(m);
               for(Messaggio msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
}
	
	}
		
	


