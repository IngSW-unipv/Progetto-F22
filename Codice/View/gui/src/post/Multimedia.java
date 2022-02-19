package post;

import java.util.ArrayList;



	public class Multimedia extends Post{
		
		// private int [] pixels;
		private String postMultID;
		private int dimensione;
		private String descrizione;
		// private List<Posts> posti;
		private int postInserito;
		private ArrayList<String> post; // O mettiamo il tipo Posts?, Posti prelevati dalla galleria
		
		
		

		public Multimedia() {
			this.post = new ArrayList<>();
			postInserito = 0;
			}
		
		

		@Override
		public void aggiungiPost() {
			 if(postInserito < post.size()) {
				 for(int i = 0; i < post.size(); i++) {
					String a = post.set(i, post.get(i) + post.size());
					 System.out.println(a);
					// System.out.println(post.size());
				 }
			} 
	  }
		
		@Override
		public boolean eliminaPost( int numPost) {
			// Eliminare dal database..
			//for( int i = 0; i < post.size(); i++) 
			if(numPost >= 0){
			post.add(post.remove(numPost));
				System.out.println(post.add(post.remove(numPost)));
				return true;
			} else {
				return false;
			}
		}

		
		/*public int[] getPixels() {
			return pixels;
		}

		public void setPixels(int[] pixels) {
			this.pixels = pixels;
		}*/

		public int getDimensione() {
			return dimensione;
		}

		public void setDimensione(int dimensione) {
			this.dimensione = dimensione;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}


		public String getPostMultID() {
			return postMultID;
		}


		public void setPostMultID(String postMultID) {
			this.postMultID = postMultID;
		}


		public int getPostInserito() {
			return postInserito;
		}


		public void setPostInserito(int postInserito) {
			this.postInserito = postInserito;
		}


		public ArrayList<String> getPost() {
			return post;
		}



		public void setPost(ArrayList<String> post) {
			this.post = post;
		}
	}

