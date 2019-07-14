package com.basdat.service;

import com.basdat.domain.NewsArticle;
import com.basdat.domain.NewsData;
import com.basdat.model.NewsArticleModel;
import com.basdat.model.NewsSourceModel;
import com.basdat.repository.NewsArticleRepository;
import com.basdat.repository.NewsSourceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewsRepositoryService {

    private final NewsArticleRepository newsArticleRepository;
    private final NewsSourceRepository newsSourceRepository;
    private final NewsData newsData;

    public void saveAllFromData() {

        log.info("Start executing saveAllFromData");

        List<NewsArticleModel> newsArticleModelList = new LinkedList<>();

        for (NewsArticle newsArticle : newsData.getArticles()) {

            log.info("SOURCE={}",newsArticle.getSource());

            NewsSourceModel newsSourceModel = new NewsSourceModel();
            newsSourceModel.setId(newsArticle.getSource().getId());
            newsSourceModel.setName(newsArticle.getSource().getName());
            newsSourceRepository.save(newsSourceModel);

            NewsArticleModel newsArticleModel = new NewsArticleModel();
            newsArticleModel.setNewsSourceModel(newsSourceModel);
            newsArticleModel.setAuthor(newsArticle.getAuthor());
            newsArticleModel.setTitle(newsArticle.getTitle());
            newsArticleModel.setDescription(newsArticle.getDescription());
            newsArticleModel.setUrl(newsArticle.getUrl());
            newsArticleModel.setUrlToImage(newsArticle.getUrlToImage());
            newsArticleModel.setPublishedAt(newsArticle.getPublishedAt());
            newsArticleModel.setContent(newsArticle.getContent());

            newsArticleRepository.save(newsArticleModel);

            newsArticleModelList.add(newsArticleModel);

            //newsSourceModel.setNewsArticleModelList(newsArticleModelList);
            //
            //newsSourceRepository.save(newsSourceModel);
        }

        log.info("All article have been copied to list");

        //newsArticleRepository.saveAll(newsArticleModelList);

        log.info("Done in executing saveAllFromData");
    }
}
