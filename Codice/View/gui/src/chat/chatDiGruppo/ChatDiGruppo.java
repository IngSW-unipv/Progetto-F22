package chat.chatDiGruppo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import chat.Chat;
import db.messaggioDiGruppo.MessaggioDiGruppoDao;
import profilo.Profilo;


public class ChatDiGruppo extends Chat{

	public ChatDiGruppo(Profilo profiloAttivo, MessaggioDiGruppo msg) {
		super(profiloAttivo);
		this.msg = msg;
	}

	private MessaggioDiGruppo msg;
	

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
		mdao.inserisciChiavi(m, msg.getIdGruppo());
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

	
	//Restituisce un ArrayList con tutti i messaggi relativi al gruppo specificato 
	public ArrayList<MessaggioDiGruppo> listaMessaggiDiUnGruppo(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAllIdGruppo(m);
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

	@Override
	public ArrayList<Messaggio> ottieniListaTuttiMessaggi() {
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();
		return gdao.selectAll();
	}
	
	
	public MessaggioDiGruppo getMsg() {
		return msg;
	}

	public void setMsg(MessaggioDiGruppo msg) {
		this.msg = msg;
	}
	
	}
		
	


