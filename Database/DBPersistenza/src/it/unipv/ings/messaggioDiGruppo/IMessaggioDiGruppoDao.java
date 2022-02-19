package it.unipv.ings.messaggioDiGruppo;

import java.util.ArrayList;

import Messaggio.MessaggioDiGruppo;

public interface IMessaggioDiGruppoDao {
	public ArrayList<MessaggioDiGruppo> selectAll();
	public boolean scriviMessaggioDiGruppo(MessaggioDiGruppo m);
	public boolean inserisciChiavi(MessaggioDiGruppo m);
	public boolean rimuoviMessaggioDiGruppo(MessaggioDiGruppo m);
	public ArrayList<MessaggioDiGruppo> cercaMessaggioDiGruppo(MessaggioDiGruppo m);
	public ArrayList<MessaggioDiGruppo> selectAllIdGruppo(MessaggioDiGruppo m);
	}

