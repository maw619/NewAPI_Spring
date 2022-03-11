package com.wolff.newsapi.dao;

import com.wolff.newsapi.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDao extends JpaRepository<Long, News> {
}
