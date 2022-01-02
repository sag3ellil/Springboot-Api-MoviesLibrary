package com.movie.Library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.Library.Entity.Categorie;


@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Long> {

}
