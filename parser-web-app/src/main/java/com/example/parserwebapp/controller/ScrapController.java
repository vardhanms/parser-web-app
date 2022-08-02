package com.example.parserwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parserwebapp.model.ScrapRequest;
import com.example.parserwebapp.model.ScrapResponse;
import com.example.parserwebapp.service.ScrapParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/scrap")
public class ScrapController {
	@Autowired
	private ScrapParser scrapParser;

    @PostMapping
    public Map<String, ScrapResponse> getData(@RequestBody ScrapRequest scrapRequest) throws IOException {
        Map<String, ScrapResponse> map = new HashMap<>();
        try {
            map.put("recipe", scrapParser.getScrapData(scrapRequest.getUrl()));
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}