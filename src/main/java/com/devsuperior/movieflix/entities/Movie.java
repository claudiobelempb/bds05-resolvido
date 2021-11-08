package com.devsuperior.movieflix.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String subTitle;
  private Integer year;
  private String ImgUrl;
  private String synopsis;

  @OneToMany(mappedBy = "movie")
  private final List<Review> reviews = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;

  public Movie(){}

  public Movie(Long id, String title, String subTitle, Integer year, String ImgUrl, String synopsis) {
    this.id = id;
    this.title = title;
    this.subTitle = subTitle;
    this.year = year;
    this.ImgUrl = ImgUrl;
    this.synopsis = synopsis;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getImgUrl() {
    return ImgUrl;
  }

  public void setImgUrl(String ImgUrl) {
    this.ImgUrl = ImgUrl;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public Genre getGenre() {
    return genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movie movie = (Movie) o;
    return id.equals(movie.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
