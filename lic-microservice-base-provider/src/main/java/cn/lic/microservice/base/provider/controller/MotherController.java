package cn.lic.microservice.base.provider.controller;

import cn.lic.microservice.base.provider.model.Book;
import cn.lic.microservice.base.provider.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@RestController
@RequestMapping("mo")
public class MotherController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("ha")
    public String ha() {
        return "ddwdwa";
    }

    private HashMap<Integer, String> isbnPool = new HashMap<Integer, String>() {
        {
            put(1, "isbn-1234");
            put(2, "isbn-4567");
        }
    };

    @RequestMapping("gb")
    public String getBook() {
        int isbnKey = new Random().nextInt(2) + 1;
        Book book = bookRepository.getByIsbn(isbnPool.get(isbnKey));
        return book.toString();
    }

}
