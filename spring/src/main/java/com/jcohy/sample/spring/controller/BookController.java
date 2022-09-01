package com.jcohy.sample.spring.controller;

import com.jcohy.sample.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

}
