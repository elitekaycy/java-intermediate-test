package com.testing.Test.testing.BottomUp;

import org.springframework.stereotype.Service;

@Service

public class UserProfileService {
  public UserProfile getUserProfile(String username) {
    return new UserProfile(username, "example@gmail.com");

  }
}
