package com.movie.Library.ConverterView;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.movie.Library.Entity.Categorie;
import com.movie.Library.Entity.Movie;
import com.movie.Library.View.MovieView;

@Component
public class MovieToMovieView implements Converter<Movie, MovieView>  {
    private CategoryToCategoryView categoryToCategoryView;
    
    public MovieToMovieView(CategoryToCategoryView categoryToCategoryView)
    {
    	this.categoryToCategoryView = categoryToCategoryView;
    }
    
	@Override
	public MovieView convert(Movie movie) {
	    	MovieView view = new MovieView();
	    	
	        view.setId(movie.getId());
	        view.setName(movie.getName());
	        view.setActors(movie.getActors());	       
	        view.setDescription(movie.getDescription());
	        

	        Categorie category = movie.getCategorie();
	        view.setCategorie(categoryToCategoryView.convert(category));
	        return view;
	}

}
