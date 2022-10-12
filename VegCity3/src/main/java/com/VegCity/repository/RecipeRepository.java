package com.VegCity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.VegCity.model.entity.RecipeEntity;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {

    @Query(value = "select * From recipe", nativeQuery = true)
    List<RecipeEntity> findAllRecipe();

    @Query(value = "select * From recipe R WHERE R.ingredienti LIKE '%:keyword%' OR R.titolo LIKE '%:keyword%'", nativeQuery = true)
    public List<RecipeEntity> search(@Param("keyword") String keyword);

}
