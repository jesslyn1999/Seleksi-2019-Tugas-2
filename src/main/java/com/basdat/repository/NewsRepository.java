package com.basdat.repository;

import com.basdat.domain.News;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {

}
