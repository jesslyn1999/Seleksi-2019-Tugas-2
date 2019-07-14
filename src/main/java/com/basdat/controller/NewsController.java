package com.basdat.controller;

import com.basdat.model.NewsArticleModel;
import com.basdat.model.NewsSourceModel;
import com.basdat.repository.NewsArticleRepository;
import com.basdat.repository.NewsSourceRepository;
import com.basdat.service.NewsRepositoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class NewsController {
    private final NewsRepositoryService newsRepositoryService;

    private final NewsSourceRepository newsSourceRepository;
    private final NewsArticleRepository newsArticleRepository;

    @RequestMapping("/")
    public String welcome(){
        newsRepositoryService.saveAllFromData();
        return "<h1>Welcome</h1>";
    }

    @RequestMapping("/sources")
    public String sourceList(){
        return newsSourceRepository.findAll().toString();
    }

    @RequestMapping("/articles")
    public String articleList(){
        return newsArticleRepository.findAll().toString();
    }



}
