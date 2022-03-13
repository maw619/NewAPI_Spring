package com.wolff.newsapi.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wolff.newsapi.dao.NewsDao;
import com.wolff.newsapi.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class NewsDaoService {

    @Autowired
    private NewsDao newsDao;


    public NewsDaoService(){

    }


    @PostConstruct
    @Scheduled(cron = "0/5 * * * * * ")
    public void writeToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        String jsonUrl = "https://newsapi.org/v2/everything?q=ufc&apiKey=23883da831e44d2791f40b63f8e3835f";

        URL url = new URL(jsonUrl);
        InputStreamReader reader = new InputStreamReader(url.openStream());
        News news = new Gson().fromJson(reader, News.class);
        List<News> listar = listAll();

        System.out.println("Saving data...");
        mapper.writeValue(Paths.get("src/main/resources/data.json").toFile(), news);
    }


    public List<News> listAll() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        List<News> news = mapper.readValue(new File(
                "src/main/resources/data.json"), new TypeReference<List<News>>(){});
        for(int i = 0;i < news.size();i++){
            saveNews(news.get(i));
        }
        return news;
    }

    public void saveNews(News news){
        newsDao.save(news);
    }


}
