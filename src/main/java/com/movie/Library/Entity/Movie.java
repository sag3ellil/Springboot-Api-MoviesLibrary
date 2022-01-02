package com.movie.Library.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "fc_movie")
public class Movie {
	    @Id
	    @Column(name = "id")
	    @GenericGenerator(
	            name = "fc_movie_id_seq",
	            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	            parameters = {
	                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "fc_movie_id_seq"),
	                    @org.hibernate.annotations.Parameter(name= "INCREMENT", value = "1"),
	                    @org.hibernate.annotations.Parameter(name = "MINVALUE", value = "1"),
	                    @org.hibernate.annotations.Parameter(name = "MAXVALUE", value = "2147483647"),
	                    @org.hibernate.annotations.Parameter(name = "CACHE", value = "1")
	            }
	    )
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fc_movie_id_seq")
	    private long id;
	    
	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "actors")
	    private String actors;
	    
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name = "id_categorie")
	    private Categorie categorie;
	    
	    @Column(name = "description")
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

		public Categorie getCategorie() {
			return categorie;
		}

		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

}
