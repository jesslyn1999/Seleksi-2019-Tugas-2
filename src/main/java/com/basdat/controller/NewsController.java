package com.basdat.controller;

import com.basdat.repository.NewsArticleRepository;
import com.basdat.repository.NewsSourceRepository;
import com.basdat.service.NewsRepositoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String welcome() {
        newsRepositoryService.saveAllFromData();
        return "<h1>Welcome</h1>"
            + "<p>Try with '/sources' or '/articles'</p>";
    }

    @RequestMapping("/sources")
    public String sourceList() {
        return newsSourceRepository.findAll().toString();
    }

    @RequestMapping("/articles")
    public String rticleList() {
        return newsArticleRepository.findAll().toString();
    }
}
