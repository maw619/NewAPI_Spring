package com.wolff.newsapi.dao;

import com.wolff.newsapi.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface NewsDao extends JpaRepository<News, Long> {
}
