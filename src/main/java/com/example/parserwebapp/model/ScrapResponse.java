package com.example.parserwebapp.model;

import java.util.List;

public class ScrapResponse {
	
	private List<String> instructions;
	private List<String> ingredients;
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}


}
