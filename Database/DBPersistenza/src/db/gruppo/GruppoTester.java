package db.gruppo;

import java.util.ArrayList;

public class GruppoTester {

	public static void main(String [] args) {
		GruppoDao gdao = new GruppoDao();
		//GruppoDB d = new GruppoDB("G00", null, null, "001", "002", null, null, "P01", null);
		//System.out.println(gdao.inserisciChiavi(d));
		
		ArrayList<String> prova = gdao.caricaGruppiProfilo("DV999");
		
		for(String g : prova) {
			System.out.println(g);
		}
	}
}
