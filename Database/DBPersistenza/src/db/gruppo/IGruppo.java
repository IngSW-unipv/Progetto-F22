package db.gruppo;

import java.util.ArrayList;


public interface IGruppo {
public ArrayList<GruppoDB> selectall();
public boolean creaGruppo(GruppoDB g);
public boolean inserisciChiavi(GruppoDB g);
public boolean cancellaGruppo(GruppoDB g);
public GruppoDB cercaGruppo(GruppoDB g);

public String vediFotoGruppo(GruppoDB g);
public boolean cambiaFotoGruppo(GruppoDB g, String s);
boolean gestisciPartecipante3(String idProfilo, GruppoDB g);
boolean gestisciPartecipante2(String idProfilo, GruppoDB g);
boolean gestisciPartecipante1(String idProfilo, GruppoDB g);
boolean gestisciPartecipante4(String idProfilo, GruppoDB g);
boolean gestisciPartecipante5(String idProfilo, GruppoDB g);
boolean gestisciPartecipante6(String idProfilo, GruppoDB g);
boolean cambiaDescrizioneGruppo(String descrizione, GruppoDB g);


}
