package com.basdat.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "news_source")
public class NewsSourceModel extends Auditable<String> {

    @Id
    private String name;

    private String id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "newsSourceModel",
               cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE })
    private List<NewsArticleModel> newsArticleModelList;

    public void addNewsArticleModel(NewsArticleModel newsArticleModel) {
        newsArticleModelList.add(newsArticleModel);
    }

    public String toString() {
        return "NewsSourceModel{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
    }
}
