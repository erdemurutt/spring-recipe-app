package com.erdemurut.springframework.bootstrap;

import com.erdemurut.springframework.domain.Category;
import com.erdemurut.springframework.domain.Difficulty;
import com.erdemurut.springframework.domain.Ingredient;
import com.erdemurut.springframework.domain.Notes;
import com.erdemurut.springframework.domain.Recipe;
import com.erdemurut.springframework.domain.UnitOfMeasure;
import com.erdemurut.springframework.repositories.CategoryRepository;
import com.erdemurut.springframework.repositories.RecipeRepository;
import com.erdemurut.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(getRecipes());
	}

	private List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<>();

		Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
		if (eachUomOptional.isEmpty()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("TableSpoon");
		if (tableSpoonUomOptional.isEmpty()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("TeaSpoon");
		if (teaSpoonUomOptional.isEmpty()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
		if (dashUomOptional.isEmpty()) {
			throw new RuntimeException("Expected UOM not found");
		}

		UnitOfMeasure eachUom = eachUomOptional.get();
		UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
		UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
		UnitOfMeasure dashUom = dashUomOptional.get();

		Optional<Category> turkishCategoryOptional = categoryRepository.findByDescription("Turkish");
		if (turkishCategoryOptional.isEmpty()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
		if (mexicanCategoryOptional.isEmpty()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Category turkishCategory = turkishCategoryOptional.get();

		Recipe guaRecipe = new Recipe();
		guaRecipe.setDescription("Perfect Guacamole");
		guaRecipe.setPrepTime(10);
		guaRecipe.setCookTime(0);
		guaRecipe.setDifficulty(Difficulty.EASY);
		guaRecipe.setDirections("Cut the avocado:\n" +
				"Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.");

		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes("Be careful handling chilis! If using, it's best to wear food-safe gloves. If no gloves are available, wash your hands thoroughly after handling, and do not touch your eyes or the area near your eyes for several hours afterwards.");
		guaRecipe.setNotes(guacNotes);

		guaRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
		guaRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(".5"), tableSpoonUom));
		guaRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom));
		guaRecipe.addIngredient(new Ingredient("Garlic", new BigDecimal(1), dashUom));

		guaRecipe.getCategories().add(turkishCategory);

		recipes.add(guaRecipe);
		return recipes;
	}
}
