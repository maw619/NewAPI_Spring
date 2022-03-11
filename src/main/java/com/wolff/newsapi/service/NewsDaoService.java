package com.wolff.newsapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolff.newsapi.dao.NewsDao;
import com.wolff.newsapi.model.News;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoService {

    @Autowired
    private NewsDao newsDao;

    public NewsDaoService(){

    }

    public void listAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        News[] news = mapper.readValue(new File(
                "C:\\Users\\marco\\SpringBootProjects\\newsapi\\newsapi\\src\\main\\resources\\data.json"), News[].class);

//        List<News>listar = new ArrayList<>();
//        listar.add(news);
        System.out.println(news[0]);

    }
}
