package pl.coderslab.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.DTO.BookDTO;
import pl.coderslab.interfaces.BookService;
import pl.coderslab.models.Book;

import java.util.*;

@Service
public class MockBookService implements BookService {
    private Map<Long, Book> booksMap = new HashMap<>();
    private Long counter = 0L;


    public MockBookService() {
        booksMap.put(counter + 1, new Book(counter + 1, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        counter++;
        booksMap.put(counter + 1, new Book(counter + 1, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        counter++;
        booksMap.put(counter + 1, new Book(counter + 1, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
        counter++;
    }

    public List<Book> getBooksList() {
        return new ArrayList<>(booksMap.values());
    }

    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(booksMap.get(id));
    }

    public Book addBook(BookDTO bookDTO) {

        validateInput(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getPublisher(), bookDTO.getType());

        Book newBook = new Book(counter + 1, bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getPublisher(), bookDTO.getType());
        booksMap.put(newBook.getId(), newBook);
        counter++;
        return newBook;
    }

    private void validateInput(String isbn, String title, String author, String publisher, String type) {
        if (isbn == null || title == null || author == null || publisher == null || type == null) {
            throw new IllegalArgumentException();
        }
    }

    public Book updateBookData(Long id, BookDTO bookDTO) {
        Book bookToUpdate = booksMap.get(id);

        if (bookDTO.getIsbn() != null) {
            bookToUpdate.setIsbn(bookDTO.getIsbn());
        }

        if (bookDTO.getTitle() != null) {
            bookToUpdate.setTitle(bookDTO.getTitle());
        }

        if (bookDTO.getAuthor() != null) {
            bookToUpdate.setAuthor(bookDTO.getAuthor());
        }

        if (bookDTO.getPublisher() != null) {
            bookToUpdate.setPublisher(bookDTO.getPublisher());
        }
        if (bookDTO.getType() != null) {
            bookToUpdate.setType(bookDTO.getType());
        }


        return bookToUpdate;
    }

    public void removeBook(Long id) {
        Optional.ofNullable(booksMap.remove(id)).orElseThrow(RuntimeException::new);

    }
}
