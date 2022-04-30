package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.interfaces.BookService;
import pl.coderslab.models.Book;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooksList();
        model.addAttribute("books", books);
        return "/books/all";
    }


}


