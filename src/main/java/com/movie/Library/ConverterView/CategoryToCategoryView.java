package com.movie.Library.ConverterView;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.movie.Library.Entity.Categorie;
import com.movie.Library.View.CategorieView;

@Component
public class CategoryToCategoryView implements Converter<Categorie, CategorieView>  {

	@Override
	public CategorieView convert(Categorie category) {
		    CategorieView view = new CategorieView();
	        view.setId(category.getId());
	        view.setName(category.getName());
	        return view;
	}

}
