package com.basdat.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "news_article")
public class NewsArticleModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_name")
    private NewsSourceModel newsSourceModel;

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public String toString() {
        return "NewsArticleModel{" +
            "id=" + id +
            ", author='" + author + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", url='" + url + '\'' +
            ", urlToImage='" + urlToImage + '\'' +
            ", publishedAt='" + publishedAt + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
