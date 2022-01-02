package com.movie.Library.BaseReqEnt;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MovieBaseReq extends BaseRequest {
	   
	    @NotEmpty
	    private String name;

	    @NotEmpty
	    private String actors;

	    private String description;	

	    @NotNull
	    private Long categorieId;

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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getCategorieId() {
			return categorieId;
		}

		public void setCategorieId(Long categorieId) {
			this.categorieId = categorieId;
		}
	    
	    
}
