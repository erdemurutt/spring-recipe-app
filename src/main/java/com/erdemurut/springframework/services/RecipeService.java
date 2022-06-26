package com.erdemurut.springframework.services;

import com.erdemurut.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
	Set<Recipe> getRecipes();

	Recipe findById(Long Id);
}
