package com.testing.Test.testing.LibraryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import com.testing.Test.testing.Library.Book;
import com.testing.Test.testing.Library.BookRepository;
import com.testing.Test.testing.Library.LibraryService;
import com.testing.Test.testing.Library.User;
import com.testing.Test.testing.Library.UserRepository;
import com.testing.Test.testing.Library.UserRequest;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

  @Mock
  private BookRepository bookRepository;

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private LibraryService libraryService;

  @Test
  public void testSearchBooks() {
    List<Book> mockBooks = new ArrayList<>();
    mockBooks.add(new Book("Spring Boot in Action", "Craig Walls"));
    when(bookRepository.findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase("Spring", "Spring"))
        .thenReturn(mockBooks);

    List<Book> foundBooks = libraryService.searchBooks("Spring");
    assertEquals(1, foundBooks.size());
    assertEquals("Spring Boot in Action", foundBooks.get(0).getName());
    assertEquals("Craig Walls", foundBooks.get(0).getAuthor());
  }

  @Test
  public void testCreateUser() {
    UserRequest userRequest = new UserRequest("john_doe", "password123");
    User user = new User(userRequest.getUsername(), userRequest.getPassword());

    doReturn(user).when(userRepository).save(any(User.class));

    User createdUser = libraryService.createUser(userRequest);
    assertEquals(user.getUsername(), createdUser.getUsername());
    assertEquals(user.getPassword(), createdUser.getPassword());
  }
}
