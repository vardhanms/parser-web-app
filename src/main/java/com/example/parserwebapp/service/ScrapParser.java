package com.example.parserwebapp.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.example.parserwebapp.model.ScrapResponse;

@Service
public class ScrapParser {
	
	public ScrapResponse getScrapData(String url) throws IOException
	{
		ScrapResponse recipe =new ScrapResponse();
    	List<String> ingredients=new ArrayList<>();
    	List<String> instructions=new ArrayList<>();
    	
        Document document = Jsoup.connect(url).get();
   
        Elements elements = document.getElementsByClass("ingredients-list");
        Elements ingredientsList = elements.select("li");

        for (Element ingredient: ingredientsList) {
        	ingredients.add(ingredient.select("li").text().toString());
        	
        }
        Elements element1 = document.getElementsByClass("field field--recipe-steps");
        Elements instructionsList = element1.select("li");

        for (Element instruction: instructionsList) {
        	instructions.add(instruction.select("li").text().toString());

        }
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        return recipe;
	}
}
