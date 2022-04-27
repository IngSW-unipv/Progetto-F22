package db.messaggioDiGruppo;

import java.util.ArrayList;

public interface IMessaggioDiGruppoDao {
	public boolean scriviMessaggioDiGruppo(MessaggioDiGruppoDB m);
	public boolean rimuoviMessaggioDiGruppo(MessaggioDiGruppoDB m);
	public ArrayList<MessaggioDiGruppoDB> cercaMessaggioDiGruppo(String m);
	public ArrayList<MessaggioDiGruppoDB> selectAllIdGruppo(MessaggioDiGruppoDB m);
	public String ottieniTesto(String m);
	}

