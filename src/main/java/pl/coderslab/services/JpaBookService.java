package pl.coderslab.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.DTO.BookDTO;
import pl.coderslab.interfaces.BookRepository;
import pl.coderslab.interfaces.BookService;
import pl.coderslab.models.Book;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBookData(Long id, BookDTO bookDTO) {
        Book bookToUpdate = null;
        if (bookRepository.findById(id).isPresent()) {
            bookToUpdate = bookRepository.findById(id).get();

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
            bookRepository.save(bookToUpdate);
        }
        return bookToUpdate;
    }

    @Override
    public void removeBook(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.delete(bookRepository.findById(id).get());
        }
    }

    @Override
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getAuthor(), bookDTO.getTitle(), bookDTO.getIsbn(), bookDTO.getPublisher(), bookDTO.getType());
        bookRepository.save(book);
        return book;
    }
}
