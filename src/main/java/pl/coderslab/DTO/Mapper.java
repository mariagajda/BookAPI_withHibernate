package pl.coderslab.DTO;

import pl.coderslab.models.Book;

public class Mapper {
    public BookDTO toDto(Book book){
        String isbn = book.getIsbn();
        String title = book.getTitle();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String type = book.getType();
        return new BookDTO(isbn, title, author, publisher, type);
    }
}
