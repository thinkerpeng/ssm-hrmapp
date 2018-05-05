package com.pwx.ssmdemo.controller;

import com.pwx.ssmdemo.entity.Book;
import com.pwx.ssmdemo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * url: /模块/资源/{id}/细分
 * Created by peng on 2018/5/4.
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        logger.info("start /book/list");
        List<Book> bookList = bookService.getList();
        model.addAttribute("bookList", bookList);
        return "list";
    }
}
