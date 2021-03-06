package com.movie.Library.Controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.Library.BaseReqEnt.MovieBaseReq;
import com.movie.Library.Entity.Movie;
import com.movie.Library.Service.MovieService;
import com.movie.Library.View.MovieView;



@RestController
@RequestMapping("/movie")
public class MovieRepository {
	
	
	private final MovieService service;
	
	public MovieRepository(MovieService movieService)
	{
		this.service = movieService;
	}
	
	
    @GetMapping
    @ResponseBody
    public Page<MovieView> getAllMovies(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllMovies(pageable); 
    }
    
    @GetMapping("/Categorie/{id}")
    @ResponseBody
    public Page<MovieView> getAllMoviesByCategorieID(@PathVariable Long id,@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllMoviesByCategorie(id,pageable); 
    }
    
    
    @GetMapping("/{id}")
    @ResponseBody
    public MovieView getMovie(@PathVariable Long id) {
        return service.getMovie(id);
    }

   
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MovieView create(@RequestBody @Valid MovieBaseReq req) {
        return service.create(req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public MovieView updateMovie(@PathVariable(name = "id") Long id,
                                 @RequestBody @Valid MovieBaseReq req) {
        Movie movie = service.findMovieOrThrow(id);
        return service.update(movie, req);
    }
}
