package it.unipv.ings.Gruppo;

import java.util.ArrayList;

import chat.chatDiGruppo.gruppo.Gruppo;

public interface IGruppo {
public ArrayList<Gruppo> selectall();
public boolean creaGruppo(Gruppo g);
public boolean inserisciChiavi(Gruppo g);
public boolean cancellaGruppo(Gruppo g);
public ArrayList<Gruppo> cercaGruppo(Gruppo g);

}
