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

import com.movie.Library.BaseReqEnt.CategorieBaseReq;
import com.movie.Library.Entity.Categorie;
import com.movie.Library.Service.CategorieService;
import com.movie.Library.View.CategorieView;



@RestController
@RequestMapping("/categorie")
public class CategorieRepository {
	
	
	private final CategorieService service;
	
	public CategorieRepository(CategorieService categorieService)
	{
		this.service = categorieService;
	}
	
	
    @GetMapping
    @ResponseBody
    public Page<CategorieView> getAllCategories(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.findAllCategories(pageable); 
    }
    
    
    @GetMapping("/{id}")
    @ResponseBody
    public CategorieView getCategorie(@PathVariable Long id) {
        return service.getMovie(id);
    }

   
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CategorieView create(@RequestBody @Valid CategorieBaseReq req) {
        return service.create(req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public CategorieView updateCategorie(@PathVariable(name = "id") Long id,
                                 @RequestBody @Valid CategorieBaseReq req) {
        Categorie categorie = service.findCategorieOrThrow(id);
        return service.update(categorie, req);
    }
}
