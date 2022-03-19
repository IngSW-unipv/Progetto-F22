package db.follow;

import java.util.ArrayList;

public class FollowTester {

	public static void main(String [] args) {
	FollowDB fdb = new FollowDB("P01", "002");
	FollowDao fdao = new FollowDao();
	//System.out.println(fdao.carica(fdb));
	//System.out.println(fdao.rimuovi(fdb.getProfiloPersonale(), fdb.getProfiloSeguito()));
	/*ArrayList<FollowDB> res = fdao.selectAll();
	for(FollowDB flw : res)
		System.out.println(flw.toString());*/
	
	ArrayList<String> seg = fdao.cercaProfSeguito(fdb.getProfiloPersonale());
	for(String sdb : seg) {
		System.out.println(sdb.toString());
	}
}
}
