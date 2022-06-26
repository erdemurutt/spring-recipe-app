package com.erdemurut.springframework.controllers;

import com.erdemurut.springframework.domain.Recipe;
import com.erdemurut.springframework.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


public class RecipeControllerTest {

	@Mock
	RecipeService recipeService;

	RecipeController recipeController;

	@Test
	void setUp() {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService);
	}

	@Test
	void testGetRecipe() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
		when(recipeService.findById(anyLong())).thenReturn(recipe);

		mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/show"));
	}

}
