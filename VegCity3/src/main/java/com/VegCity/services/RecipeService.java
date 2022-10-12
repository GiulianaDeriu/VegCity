package com.VegCity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VegCity.model.Recipe;
import com.VegCity.model.entity.RecipeEntity;
import com.VegCity.model.entity.UserEntity;
import com.VegCity.repository.RecipeRepository;
import com.VegCity.repository.UserRepository;
import com.VegCity.utility.Utility;

@Service
public class RecipeService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private Utility utility;

    public Object createRecipe(Recipe recipe) throws Exception {

        Optional<UserEntity> userEntity = userRepository.findByUsername(recipe.getUser().getName());

        RecipeEntity recipeEntity = utility.convertRecipe(recipe);
        if (recipeEntity != null) {

            if (recipeEntity.getId() != null) {
                Optional<RecipeEntity> recipeFromDb = recipeRepository.findById(recipeEntity.getId());
                if (recipeFromDb.isPresent()) {
                    update(recipe, recipeFromDb);
                } else {
                    System.out.println("ricetta salvata");
                    recipeEntity.setUser(userEntity.get());
                    recipeRepository.save(recipeEntity);

                    userEntity.get().getRecipe().add(recipeEntity);

                    userRepository.save(userEntity.get());
                }
            } else {
                System.out.println("ricetta salvata");
                recipeEntity.setUser(userEntity.get());
                recipeRepository.save(recipeEntity);

                userEntity.get().getRecipe().add(recipeEntity);

                userRepository.save(userEntity.get());
            }

        }
        return recipe;
    }

    public RecipeEntity update(Recipe recipe, Optional<RecipeEntity> recipeFromDb) {

        recipeFromDb.get().setIngredienti(recipe.getIngredienti());
        recipeFromDb.get().setPreparazione(recipe.getPreparazione());
        recipeFromDb.get().setCottura(recipe.getCottura());
        recipeFromDb.get().setTitolo(recipe.getTitolo());
        recipeRepository.save(recipeFromDb.get());

        return recipeFromDb.get();
    }

    public void delete(String id) {

        if (id != null) {
            Optional<RecipeEntity> deleteRecipe = recipeRepository.findById(Long.parseLong((id)));
            UserEntity userEntity = deleteRecipe.get().getUser();
            recipeRepository.delete(deleteRecipe.get());
            userEntity.getRecipe().remove(deleteRecipe.get());
            userRepository.save(userEntity);
        }

    }

    public List<Recipe> getAll() {
        List<Recipe> responseList = new ArrayList<Recipe>();

        List<RecipeEntity> requestList = recipeRepository.findAllRecipe();

        if (requestList != null && !requestList.isEmpty()) {
            responseList = utility.getAllRecipeOfUser(requestList);
        }

        return responseList;
    }

    public List<Recipe> getAllByUsername(String username) {

        List<Recipe> listaRicetteUtente = new ArrayList<Recipe>();

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        if (userEntity.isPresent()) {
            listaRicetteUtente = utility.getAllRecipeOfUser(userEntity.get().getRecipe());
        }

        return listaRicetteUtente;
    }

    public List<RecipeEntity> search(String keyword) {
        return recipeRepository.search(keyword);
    }

    public Recipe findById(Long id) throws Exception {

        Optional<RecipeEntity> recipEntity = recipeRepository.findById(id);
        Recipe recipe = new Recipe();

        if (recipEntity.isPresent()) {
            recipe = utility.convertRecipeEntity(recipEntity.get());
        }

        return recipe;
    }
}
