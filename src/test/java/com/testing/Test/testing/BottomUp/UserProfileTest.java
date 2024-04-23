package com.testing.Test.testing.BottomUp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserProfileTest {

  @Mock
  private UserProfileService userProfileService;

  @Test
  public void testGetUserProfile() {
    UserProfile userProfile = new UserProfile("testUser", "test@gmail.com");
    when(userProfileService.getUserProfile("testUser")).thenReturn(userProfile);

    UserProfile result = userProfileService.getUserProfile("testUser");
    assertEquals("testUser", result.getUsername());
    assertEquals("test@gmail.com", result.getEmail());
  }

}
