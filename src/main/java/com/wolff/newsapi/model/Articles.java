package com.wolff.newsapi.model;

import java.util.List;

public class Articles {

    private Long articlesId;

    private List<Source>source;

    private String author;

    private String title;

    private String description;

    private String url;

    private String urlToImage;

    private String pubishedAt;

    private String content;

    public Articles(){
    }

    public Long getArticlesId() {
        return articlesId;
    }

    public void setArticlesId(Long articlesId) {
        this.articlesId = articlesId;
    }

    public List<Source> getSource() {
        return source;
    }

    public void setSource(List<Source> source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPubishedAt() {
        return pubishedAt;
    }

    public void setPubishedAt(String pubishedAt) {
        this.pubishedAt = pubishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
