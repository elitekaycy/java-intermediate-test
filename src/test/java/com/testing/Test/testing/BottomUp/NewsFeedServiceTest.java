package com.testing.Test.testing.BottomUp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NewsFeedServiceTest {

  @Mock
  private NewsFeedService newsFeedService;

  @Test
  public void testGetNewsFeed() {
    List<String> dummyNewsFeed = Arrays.asList("Post 1", "Post 2", "Post 3");
    when(newsFeedService.getNewsFeed()).thenReturn(dummyNewsFeed);

    List<String> result = newsFeedService.getNewsFeed();
    assertEquals(3, result.size());
    assertTrue(result.contains("Post 1"));
    assertTrue(result.contains("Post 2"));
    assertTrue(result.contains("Post 3"));
  }
}
