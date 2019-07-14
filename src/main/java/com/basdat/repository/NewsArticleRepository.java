package com.basdat.repository;

import com.basdat.model.NewsArticleModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsArticleRepository extends JpaRepository<NewsArticleModel, Integer> {

    Optional<NewsArticleModel> findById(Integer id);
}
