package chat.chatDiGruppo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Messaggio.MessaggioDiGruppo;
import it.unipv.ings.messaggioDiGruppo.MessaggioDiGruppoDao;


public class ChatDiGruppo implements IChatDiGruppo{

	@Override
	public boolean scriviMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		boolean b;
		b = mdao.scriviMessaggioDiGruppo(m);
		return b;
	}

	@Override
	public boolean eliminaMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		boolean b;
		b = mdao.rimuoviMessaggioDiGruppo(m);
		return b;
	}

	@Override
	public ArrayList<MessaggioDiGruppo> cercaMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.cercaMessaggioDiGruppo(m);
	}

	@Override
	public ArrayList<MessaggioDiGruppo> selectAll() {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAll();
	}

	@Override
	public ArrayList<MessaggioDiGruppo> selectAllIdGruppo(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAllIdGruppo(m);
	}

	@Override
	public void selectAllRipetuto() {
		Timer timer = new Timer();
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();   
		timer.schedule(new TimerTask() {
			int i = 0;
		    public void run() {
		       
               ArrayList<MessaggioDiGruppo> show = gdao.selectAll();
               for(MessaggioDiGruppo msg : show)
            	   System.out.println(msg.toString());
                   i++;
                   if(i == 5)
            	      timer.cancel();
		   
		    }
		 }, 0, 60 * 1000);
		}
	

	@Override
	public boolean inserisciChiavi(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		boolean b;
		b = mdao.rimuoviMessaggioDiGruppo(m);
		return b;
	}
		
	}


