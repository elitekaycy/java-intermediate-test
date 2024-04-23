package com.testing.Test.testing.BottomUp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsfeed")
public class NewsFeedController {

  @Autowired
  private NewsFeedService newsFeedService;

  @GetMapping
  public ResponseEntity<List<String>> getNewsFeed() {
    List<String> newsFeed = newsFeedService.getNewsFeed();
    return ResponseEntity.ok(newsFeed);
  }
}
