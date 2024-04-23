package com.testing.Test.testing.Library;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;

  public LibraryService(BookRepository bookRepository, UserRepository userRepository) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
  }

  public List<Book> searchBooks(String query) {
    List<Book> books = bookRepository.findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(query, query);
    return books;
  }

  public User createUser(UserRequest userRequest) {

    User user = new User();
    user.setUsername(userRequest.getUsername());
    user.setPassword(userRequest.getPassword());
    return userRepository.save(user);
  }

}
