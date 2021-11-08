package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.UserProfileDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserAuthService userAuthService;

  @Transactional(readOnly = true)
  public UserProfileDTO profileForCurrentUser(){
    User user = userAuthService.authenticated();

    Optional<User> obj = userRepository.findById(user.getId());
    User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    return new UserProfileDTO((entity));
  }
}
