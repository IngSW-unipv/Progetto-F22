package db.messaggio.messaggioDiGruppo;

import java.util.ArrayList;

public interface IMessaggioDiGruppoDao {

	public ArrayList<MessaggioDiGruppoDB> selectAllIdGruppo(MessaggioDiGruppoDB m);
	public String ottieniTesto(String m);
	}

