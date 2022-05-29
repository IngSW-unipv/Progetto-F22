package db.LikeDislike;

import java.util.ArrayList;

import db.LikeDislike.LikeMap.LikeMapDB;
import db.LikeDislike.LikeMap.LikeMapDao;
import db.LikeDislike.dislikeMap.DislikeMapDB;
import db.LikeDislike.dislikeMap.DislikeMapDao;

public class Tester {
public static void main(String[]args) {
	LikeMapDB l = new LikeMapDB("fagqwf","fqgy");
	DislikeMapDB d = new DislikeMapDB("hgwfi","ifgi");
	LikeMapDao ldao = new LikeMapDao(); 
	DislikeMapDao dDao = new DislikeMapDao();
	System.out.println(ldao.carica(l.getProfilo(),l.getPost()));
	System.out.println(dDao.carica(d.getProfilo(), d.getPost()));
	ArrayList<String> dislike = dDao.cerca(d.getProfilo(), d.getPost());
	for(String res: dislike)
		System.out.println(res.toString());
}
}
