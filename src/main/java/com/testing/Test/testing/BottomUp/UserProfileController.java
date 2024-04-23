package com.testing.Test.testing.BottomUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

  @Autowired
  private UserProfileService userProfileService;

  @GetMapping("/{username}")
  public ResponseEntity<UserProfile> getUserProfile(@PathVariable String username) {
    UserProfile userProfile = userProfileService.getUserProfile(username);
    return ResponseEntity.ok(userProfile);
  }
}
