package com.tobimadehin.moviefav.movies;

import jakarta.persistence.*;

@Entity
public class Movies {
    @Id
    @SequenceGenerator(
            name = "movies_sequence",
            sequenceName = "movies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movies_sequence"
    )
    @Column(
            name = "movie_id",
            updatable = false
    )
    private Long movie_id;
    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;
    @Column(
            name = "thumbnail",
            columnDefinition = "TEXT"
    )
    private String thumbnail;
    @Column(
            name = "user_id",
            nullable = false,
            columnDefinition = "FLOAT8"
    )
    private Long user_id;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;
    @Column(
            name = "category",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String category;

    private Movies() {}

    public Movies(String title, String thumbnail, Long user_id, String description, String category) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.user_id = user_id;
        this.description = description;
        this.category = category;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", user_id=" + user_id +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
