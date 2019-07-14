package com.basdat.repository;

import com.basdat.model.NewsSourceModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsSourceRepository extends JpaRepository<NewsSourceModel, Integer> {

    Optional<NewsSourceModel> findById(Integer id);
}
