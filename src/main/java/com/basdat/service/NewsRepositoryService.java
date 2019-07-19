package com.basdat.service;

import com.basdat.domain.NewsArticle;
import com.basdat.domain.NewsData;
import com.basdat.dto.NewsArticleModel;
import com.basdat.dto.NewsSourceModel;
import com.basdat.repository.NewsSourceRepository;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewsRepositoryService {

    private final NewsSourceRepository newsSourceRepository;
    private final NewsData newsData;

    public void saveAllFromData() {

        log.info("Start executing saveAllFromData");

        for (NewsArticle newsArticle : newsData.getArticles()) {

            NewsSourceModel newsSourceModel;

            if (newsSourceRepository.existsById(newsArticle.getSource().getName())) {
                newsSourceModel = newsSourceRepository.findById(newsArticle.getSource().getName()).get();
            } else {
                newsSourceModel = new NewsSourceModel();
                newsSourceModel.setName(
                    newsArticle.getSource().getName());  // Name is primary key of entity 'news_source'
                newsSourceModel.setNewsArticleModelList(new LinkedList<>());
            }

            newsSourceModel.setId(newsArticle.getSource().getId());  // Here the 'Id' is not primary key

            NewsArticleModel newsArticleModel = new NewsArticleModel();
            newsArticleModel.setNewsSourceModel(newsSourceModel);
            newsArticleModel.setAuthor(newsArticle.getAuthor());
            newsArticleModel.setTitle(newsArticle.getTitle());
            newsArticleModel.setDescription(newsArticle.getDescription());
            newsArticleModel.setUrl(newsArticle.getUrl());
            newsArticleModel.setUrlToImage(newsArticle.getUrlToImage());
            newsArticleModel.setPublishedAt(newsArticle.getPublishedAt());
            newsArticleModel.setContent(newsArticle.getContent());

            newsSourceModel.addNewsArticleModel(newsArticleModel);

            newsSourceRepository.save(newsSourceModel);
        }

        log.info("Done in executing saveAllFromData");
    }
}
