package com.basdat.service;

import com.basdat.domain.News;
import com.basdat.repository.NewsRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Iterable<News> list() {
        return newsRepository.findAll();
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public void save(List<News> someNews) {
        newsRepository.saveAll(someNews);
    }
}
