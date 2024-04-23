package com.testing.Test.testing.BottomUp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NewsFeedService {
  public List<String> getNewsFeed() {
    return Arrays.asList("Post 1", "Post 2", "Post 3");
  }
}
