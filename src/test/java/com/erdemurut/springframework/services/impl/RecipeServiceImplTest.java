package com.erdemurut.springframework.services.impl;

import com.erdemurut.springframework.domain.Recipe;
import com.erdemurut.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void getRecipes() {

		Recipe recipe = new Recipe();
		HashSet receipesData = new HashSet();
		receipesData.add(recipe);

		when(recipeRepository.findAll()).thenReturn(receipesData);

		Set<Recipe> recipes = recipeService.getRecipes();

		verify(recipeRepository, times(1)).findAll();
		assertEquals(recipes.size(), 1);
	}
}