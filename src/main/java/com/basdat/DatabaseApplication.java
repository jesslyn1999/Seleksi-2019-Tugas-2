package com.basdat;

import com.basdat.domain.News;
import com.basdat.service.NewsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(NewsService newsService) {
        return args -> {
            //read JSON and load JSON
            ObjectMapper mapper = new ObjectMapper();

            TypeReference<List<News>> typeReference = new TypeReference<List<News>>() {};

            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/kompasnews.json");

            try {
                System.out.println("JELLLOO");
                List<News> someNews = mapper.readValue(inputStream, typeReference);
                System.out.println("JELLLOO2");
                newsService.save(someNews);
                System.out.println("JELLLOO3");
                System.out.println("News Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save news: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("U got error: " + e.getMessage());
            }
        };
    }
}
