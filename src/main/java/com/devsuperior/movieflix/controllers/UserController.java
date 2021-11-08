package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.dto.UserProfileDTO;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/users")
public class UserController implements Serializable {

  private static final long serialVersionUID = 1L;

  @Autowired
  private UserService userService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> show(@PathVariable Long id) {
    UserDTO userDTO = userService.show(id);
    return ResponseEntity.ok().body(userDTO);
  }
}
