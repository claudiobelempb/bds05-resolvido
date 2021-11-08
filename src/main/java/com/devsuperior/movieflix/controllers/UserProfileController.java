package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.UserProfileDTO;
import com.devsuperior.movieflix.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users/profile")
public class UserProfileController {

  @Autowired
  private UserProfileService userProfileService;

  @GetMapping
  public ResponseEntity<UserProfileDTO> profileForCurrentUser(){
    UserProfileDTO user = userProfileService.profileForCurrentUser();
    return ResponseEntity.ok().body(user);
  }

}
