package db.gruppo;

import java.util.ArrayList;


public interface IGruppo {
public ArrayList<GruppoDB> selectall();
public boolean creaGruppo(GruppoDB g);
public boolean inserisciChiavi(GruppoDB g);
public boolean cancellaGruppo(GruppoDB g);
public ArrayList<GruppoDB> cercaGruppo(GruppoDB g);

}
