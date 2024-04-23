package com.testing.Test.testing.LibraryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;

import com.testing.Test.testing.Library.Book;
import com.testing.Test.testing.Library.BookRepository;
import com.testing.Test.testing.Library.LibraryService;
import com.testing.Test.testing.Library.User;
import com.testing.Test.testing.Library.UserRepository;
import com.testing.Test.testing.Library.UserRequest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class LibraryServiceTestH2 {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private UserRepository userRepository;

  private LibraryService libraryService;

  @BeforeEach
  void setup() {
    libraryService = new LibraryService(bookRepository, userRepository);
  }

  @Test
  public void testSearchBooks() {

    Book book = new Book("Spring Boot in Action", "Craig Walls");
    bookRepository.save(book);

    List<Book> foundBooks = libraryService.searchBooks("Spring");
    assertEquals(1, foundBooks.size());
    assertEquals("Spring Boot in Action", foundBooks.get(0).getName());
    assertEquals("Craig Walls", foundBooks.get(0).getAuthor());
  }

  @Test
  public void testCreateUser() {

    UserRequest userRequest = new UserRequest("john_doe", "password123");
    User createdUser = libraryService.createUser(userRequest);

    User fetchedUser = userRepository.findById(createdUser.getId()).orElse(null);
    assertEquals(userRequest.getUsername(), fetchedUser.getUsername());
    assertEquals(userRequest.getPassword(), fetchedUser.getPassword());
  }
}
