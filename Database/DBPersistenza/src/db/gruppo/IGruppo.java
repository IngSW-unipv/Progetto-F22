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
boolean inserisciPartecipante3(String idProfilo, GruppoDB g);
boolean inserisciPartecipante2(String idProfilo, GruppoDB g);
boolean inserisciPartecipante1(String idProfilo, GruppoDB g);
boolean inserisciPartecipante4(String idProfilo, GruppoDB g);
boolean inserisciPartecipante5(String idProfilo, GruppoDB g);
boolean inserisciPartecipante6(String idProfilo, GruppoDB g);


}
