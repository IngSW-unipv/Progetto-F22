package db.messaggioDiGruppo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;

public interface IMessaggioDiGruppoDao {
	public ArrayList<Messaggio> selectAll();
	public boolean scriviMessaggioDiGruppo(Messaggio m);
	public boolean inserisciChiavi(Messaggio m, String gruppo);
	public boolean rimuoviMessaggioDiGruppo(Messaggio m);
	public ArrayList<Messaggio> cercaMessaggioDiGruppo(Messaggio m);
	public ArrayList<MessaggioDiGruppo> selectAllIdGruppo(MessaggioDiGruppo m);
	public void ottieniTesto(Messaggio m);
	}

