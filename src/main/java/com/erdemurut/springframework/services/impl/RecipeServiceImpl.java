package com.erdemurut.springframework.services.impl;

import com.erdemurut.springframework.domain.Recipe;
import com.erdemurut.springframework.repositories.RecipeRepository;
import com.erdemurut.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}

	@Override
	public Recipe findById(Long Id) {
		Optional<Recipe> recipeOptional = recipeRepository.findById(Id);
		if (recipeOptional.isEmpty()) {
			throw new RuntimeException("Recipe Not Found!");
		}
		return recipeOptional.get();
	}
}
