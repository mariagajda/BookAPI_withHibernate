package pl.coderslab.interfaces;

import pl.coderslab.DTO.BookDTO;
import pl.coderslab.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooksList();
    Optional<Book> getBookById(Long id);
    Book updateBookData(Long id, BookDTO bookDTO);
    void removeBook(Long id);
    Book addBook(BookDTO bookDTO);
}
