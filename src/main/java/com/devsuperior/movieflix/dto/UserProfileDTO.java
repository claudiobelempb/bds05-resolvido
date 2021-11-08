package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.User;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class UserProfileDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank(message = "Campo nome é obrigratório")
  private Long id;

  @NotBlank(message = "Campo nome é obrigratório")
  private String name;

  private String email;

  public UserProfileDTO(){}

  public UserProfileDTO(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public UserProfileDTO(User user) {
    id = user.getId();
    name = user.getName();
    email = user.getEmail();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
