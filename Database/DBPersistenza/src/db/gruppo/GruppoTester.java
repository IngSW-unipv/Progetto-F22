package db.gruppo;

public class GruppoTester {

	public static void main(String [] args) {
		GruppoDao gdao = new GruppoDao();
		GruppoDB d = new GruppoDB("G00", null, null, "001", "002", null, null, "P01", null, "P01");
		System.out.println(gdao.inserisciChiavi(d));
	}
}
