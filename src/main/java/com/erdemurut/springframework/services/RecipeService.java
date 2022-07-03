package com.erdemurut.springframework.services;

import com.erdemurut.springframework.commands.RecipeCommand;
import com.erdemurut.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
	Set<Recipe> getRecipes();

	Recipe findById(Long id);

	RecipeCommand findCommandById(Long id);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

	void deleteById(Long id);
}
