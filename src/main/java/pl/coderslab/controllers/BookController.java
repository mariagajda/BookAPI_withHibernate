package pl.coderslab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.DTO.BookDTO;
import pl.coderslab.models.Book;
import pl.coderslab.interfaces.BookService;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity getList() {
        return ResponseEntity.ok(bookService.getBooksList());
    }

    @PostMapping("")
    public ResponseEntity addBook(BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.addBook(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity bookInfo(@PathVariable Long id) {
        if (bookService.getBooksList().stream()
                .noneMatch(book -> book.getId().equals(id)) || id.equals(null) || id.toString().isEmpty()) {
            return new ResponseEntity("Brak podanego id książki do wyświetlania lub wskazany id poza zakresem", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, BookDTO bookDTO) {
        if (bookService.getBooksList().stream()
                .noneMatch(book -> book.getId().equals(id)) || id.equals(null) || id.toString().isEmpty()) {
            return new ResponseEntity("Brak podanego id książki do aktualizacji lub wskazany id poza zakresem", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(bookService.updateBookData(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (bookService.getBooksList().stream()
                .noneMatch(book -> book.getId().equals(id)) || id.equals(null) || id.toString().isEmpty()) {
            return new ResponseEntity("Brak podanego id książki do usunięcia lub wskazany id poza zakresem", HttpStatus.NOT_FOUND);
        } else {
            bookService.removeBook(id);
            return ResponseEntity.ok("Boook deleted");
        }
    }
}


