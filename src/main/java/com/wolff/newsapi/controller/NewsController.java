package com.wolff.newsapi.controller;

import com.wolff.newsapi.model.News;
import com.wolff.newsapi.service.NewsDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v2/news")
public class NewsController {

    @Autowired
    private NewsDaoService newsDaoService;

    @GetMapping
    public ResponseEntity<News>listNews() throws IOException {
        return new ResponseEntity(newsDaoService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<News> save() throws IOException {

        for(int i = 0; i < newsDaoService.listAll().size();i++){
            System.out.println("Saving from controller");
            newsDaoService.saveNews(newsDaoService.listAll().get(i));
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
