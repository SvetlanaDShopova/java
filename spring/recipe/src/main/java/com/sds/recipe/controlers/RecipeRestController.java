package com.sds.recipe.controlers;

import com.sds.recipe.models.Recipe;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipes")
public class RecipeRestController {

    public List<Recipe> listRecipes(){
        return null;
    }

    public Recipe getRecipe(Long id){
        return null;
    }

    public Recipe createRecipe(Recipe recipe){

        return null;
    }

    public Recipe updateRecipe(Recipe recipe){
        return null;
    }

    public void deleteRecipe(Long id){

    }

}
