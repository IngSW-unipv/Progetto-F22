package db.LikeDislike.LikeMap;

public class LikeMapDB {

	public LikeMapDB(String profilo, String post) {
		this.profilo = profilo;
		this.post = post;
	}
	private String profilo;
	private String post;
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "LikeDB [profilo=" + profilo + ", post=" + post + "]";
	}
}
