package com.movie.Library.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movie.Library.BaseReqEnt.CategorieBaseReq;
import com.movie.Library.BaseReqEnt.MovieBaseReq;
import com.movie.Library.ConverterView.CategoryToCategoryView;
import com.movie.Library.Entity.Categorie;
import com.movie.Library.Entity.Movie;
import com.movie.Library.Error.EntityNotFoundException;
import com.movie.Library.Repository.*;
import com.movie.Library.Util.MessageUtil;
import com.movie.Library.View.CategorieView;
import com.movie.Library.View.MovieView;


@Service
public class CategorieService {

	     private final CategoryToCategoryView categorieToCategorieView;
	     private final CategorieRepo categorieRepo;
	     private final MessageUtil messageUtil;
	    
	     public CategorieService(CategoryToCategoryView categoryToCategoryView, CategorieRepo categorieRepo , MessageUtil messageUtil)
	     {
		   this.categorieToCategorieView  =  categoryToCategoryView;
		   this.categorieRepo     =  categorieRepo;
		   this.messageUtil       =  messageUtil;
	     }
	     
	     
	     
         public Page<CategorieView> findAllCategories(Pageable pageable) {
	    	 
			 Page<Categorie> categories = categorieRepo.findAll(pageable);
			 List<CategorieView> categorieViews = new ArrayList<>();
			
			 categories.forEach(categorie -> {
				 CategorieView categorieView = categorieToCategorieView.convert(categorie);
				 categorieViews.add(categorieView);
			 });
			 
			 return new PageImpl<>(categorieViews, pageable, categories.getTotalElements());
	     }
         
         public CategorieView update(Categorie categorie, CategorieBaseReq req) {
        	 Categorie newCategorie = this.prepare(categorie, req);
        	 Categorie categorieForSave = categorieRepo.save(newCategorie);
	         return categorieToCategorieView.convert(categorieForSave);
	     }
         
         @Transactional
	     public void delete(Long id) {
	         try {
	             categorieRepo.deleteById(id);
	         } catch (EmptyResultDataAccessException e) {
	             throw new EntityNotFoundException(messageUtil.getMessage("categorie.NotFound", id));
	         }
	     }
	     
	     public Categorie findCategorieOrThrow(Long id) {
	         return categorieRepo.findById(id)
	                 .orElseThrow(() -> new EntityNotFoundException(messageUtil.getMessage("categorie.NotFound", id)));
	     }

	     public CategorieView getMovie(Long id) {
	    	 Categorie categorie = findCategorieOrThrow(id);
	         return categorieToCategorieView.convert(categorie);
	     }
         
	     public CategorieView create( CategorieBaseReq req) {
	         Categorie categorie = new Categorie();
	         this.prepare(categorie,req);
	         Categorie categorieSave = categorieRepo.save(categorie);
	         return categorieToCategorieView.convert(categorieSave);
	     }
	     
         private Categorie prepare(Categorie categorie, CategorieBaseReq req) {
        	 categorie.setName(req.getName());  
	         return categorie;
	     }
	     

}
