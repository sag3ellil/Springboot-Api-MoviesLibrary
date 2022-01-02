package com.movie.Library.View;

import com.movie.Library.Entity.Categorie;

public class MovieView {
	  private long id;
	    
	    
	    private String name;
	    
	  
	    private String actors;
	    
	 
	    private CategorieView categorie;
	    
	 
	    private String description;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getActors() {
			return actors;
		}

		public void setActors(String actors) {
			this.actors = actors;
		}

		public CategorieView getCategorie() {
			return categorie;
		}

		public void setCategorie(CategorieView categorie) {
			this.categorie = categorie;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

}
