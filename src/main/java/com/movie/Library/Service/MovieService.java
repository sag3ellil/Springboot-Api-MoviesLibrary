package com.movie.Library.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movie.Library.BaseReqEnt.MovieBaseReq;
import com.movie.Library.ConverterView.MovieToMovieView;
import com.movie.Library.Entity.Movie;
import com.movie.Library.Error.EntityNotFoundException;
import com.movie.Library.Repository.*;
import com.movie.Library.Util.MessageUtil;
import com.movie.Library.View.MovieView;


@Service
public class MovieService {

	     private final movieRepo movieRepo;
	     private final MovieToMovieView movieToMovieView;
	     private final CategorieRepo categorieRepo;
	     private final MessageUtil messageUtil;
	    
	     public MovieService(movieRepo movieRepo,MovieToMovieView movieToMovieView, CategorieRepo categorieRepo , MessageUtil messageUtil)
	     {
		   this.movieRepo         =  movieRepo;
		   this.movieToMovieView  =  movieToMovieView;
		   this.categorieRepo     =  categorieRepo;
		   this.messageUtil       =  messageUtil;
	     }
	     
	     public Page<MovieView> findAllMovies(Pageable pageable) {
	    	 
			 Page<Movie> movies = movieRepo.findAll(pageable);
			 List<MovieView> movieViews = new ArrayList<>();
			
			 movies.forEach(movie -> {
				 MovieView movieView = movieToMovieView.convert(movie);
				 movieViews.add(movieView);
			 });
			 
			 return new PageImpl<>(movieViews, pageable, movies.getTotalElements());
	     }
	     
         public Page<MovieView> findAllMoviesByCategorie(Long id,Pageable pageable) {
	    	 
			 Page<Movie> movies = movieRepo.findAll(pageable);
			 List<MovieView> movieViews = new ArrayList<>();
			
			 movies.forEach(movie -> {
				 if(movie.getCategorie().getId()==id)
				 {
				 MovieView movieView = movieToMovieView.convert(movie);
				 movieViews.add(movieView);
				 }
			 });
			 
			 return new PageImpl<>(movieViews, pageable, movies.getTotalElements());
	     }
	     
	     public MovieView update(Movie movie, MovieBaseReq req) {
	    	 Movie newMovie = this.prepare(movie, req);
	    	 Movie movieForSave = movieRepo.save(newMovie);
	         return movieToMovieView.convert(movieForSave);
	     }
	     @Transactional
	     public void delete(Long id) {
	         try {
	             movieRepo.deleteById(id);
	         } catch (EmptyResultDataAccessException e) {
	             throw new EntityNotFoundException(messageUtil.getMessage("movie.NotFound", id));
	         }
	     }
	     
	     public Movie findMovieOrThrow(Long id) {
	         return movieRepo.findById(id)
	                 .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("movie.NotFound", id)));
	     }

	     public MovieView getMovie(Long id) {
	    	 Movie movie = findMovieOrThrow(id);
	         return movieToMovieView.convert(movie);
	     }

	    
	     
	     
	     public MovieView create( MovieBaseReq req) {
	         Movie movie = new Movie();
	         this.prepare(movie,req);
	         Movie movieSave = movieRepo.save(movie);
	         return movieToMovieView.convert(movieSave);
	     }
	     
	     private Movie prepare(Movie movie, MovieBaseReq req) {
	    	 movie.setName(req.getName());
	    	 movie.setActors(req.getActors());
	    	 movie.setDescription(req.getDescription());	    
	    	 movie.setCategorie(categorieRepo.getOne(req.getCategorieId()));
	         return movie;
	     }
	     
}
