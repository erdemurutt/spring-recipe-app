package com.erdemurut.springframework.services.impl;

import com.erdemurut.springframework.domain.Recipe;
import com.erdemurut.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RecipeServiceImplTest {
//
//	RecipeServiceImpl recipeService;
//
//	@Mock
//	RecipeRepository recipeRepository;
//
//	@BeforeEach
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//
//		recipeService = new RecipeServiceImpl(recipeRepository);
//	}
//
//	@Test
//	void getRecipes() {
//
//		Recipe recipe = new Recipe();
//		HashSet receipesData = new HashSet();
//		receipesData.add(recipe);
//
//		when(recipeRepository.findAll()).thenReturn(receipesData);
//
//		Set<Recipe> recipes = recipeService.getRecipes();
//
//		verify(recipeRepository, times(1)).findAll();
//		assertEquals(recipes.size(), 1);
//	}
//
//	@Test
//	void getRecipeByIdTest() throws Exception {
//
//		Recipe recipe = new Recipe();
//		recipe.setId(1L);
//		Optional<Recipe> recipeOptional = Optional.of(recipe);
//
//		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
//
//		Recipe recipeReturned = recipeService.findById(1L);
//
//		assertNotNull("Null recipe returned", recipeReturned);
//		verify(recipeRepository, times(1)).findById(anyLong());
//		verify(recipeRepository, never()).findAll();
//	}
}