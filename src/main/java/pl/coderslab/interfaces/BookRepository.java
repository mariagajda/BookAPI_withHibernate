package pl.coderslab.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {



}
