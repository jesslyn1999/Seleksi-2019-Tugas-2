package com.basdat.service;

import com.basdat.domain.NewsData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

@Configuration
@Slf4j
@RequiredArgsConstructor
@EnableAsync
public class NewsObjectMapperService {

    @Value("${news.save.json.path}")
    private String jsonDataLocationPath;

    private final ObjectMapper objectMapper;

    @Bean
    public NewsData newsData(){
        try {
            FileReader reader = new FileReader(jsonDataLocationPath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return objectMapper.convertValue(jsonObject, NewsData.class);
        } catch (Exception exc){
            log.info("Error in creating newsData error={}", exc.getMessage());
            return null;
        }

    }

}
