package db.LikeDislike.dislikeMap;

public class DislikeMapDB {

	public DislikeMapDB(String profilo,String post) {
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
		return "DislikeMap [profilo=" + profilo + ", post=" + post + "]";
	}
	
}
