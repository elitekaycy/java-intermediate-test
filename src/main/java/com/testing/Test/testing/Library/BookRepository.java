package com.testing.Test.testing.Library;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findByNameContainingIgnoreCaseOrAuthorContainingIgnoreCase(String query, String query2);

}
