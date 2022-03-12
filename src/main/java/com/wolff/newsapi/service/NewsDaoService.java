package com.wolff.newsapi.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolff.newsapi.dao.NewsDao;
import com.wolff.newsapi.model.News;
import com.wolff.newsapi.model.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;


@Service
public class NewsDaoService {

    @Autowired
    private NewsDao newsDao;

    public NewsDaoService(){

    }

    public void listAll() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        News []news  = mapper.readValue(new File(
                "src/main/resources/data.json"), News[].class);

        for(int i = 0;i < news.length;i++){
            System.out.println(news[i].getArticles());
        }

    }
}
