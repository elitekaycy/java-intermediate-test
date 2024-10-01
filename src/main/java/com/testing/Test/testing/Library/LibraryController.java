package com.testing.Test.testing.Library;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LibraryController {

  private final LibraryService libraryService;

  public LibraryController(LibraryService libraryService) {
    this.libraryService = libraryService;
  }

  @GetMapping("/books")
  public List<Book> searchBooks(@RequestParam("query") String query) {
    return libraryService.searchBooks(query);
  }

  @PostMapping("/user")
  public User createUser(@RequestBody UserRequest userRequest) {
    return libraryService.createUser(userRequest);
  }

}
