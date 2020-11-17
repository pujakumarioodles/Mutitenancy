package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dbapi.MyUser.Myuser;
import com.example.demo.dbapi.MyuserRepo.MyUserRepo;
import com.example.demo.dbapi.book.Book;
import com.example.demo.dbapi.bookrepo.BookRepo;

@RestController
@SpringBootApplication
public class MultitenancyApplication {
	
	
	@Autowired
	private MyUserRepo myUserRepo;
	
	
	@Autowired
	private BookRepo bookRepo;
	
	@PostConstruct
	public void addData2Db()
	{
		myUserRepo.saveAll(Stream.of(new Myuser(1,"puja"),new Myuser(2,"anuska"),
				new Myuser(3,"priya")).collect(Collectors.toList()));
		

		bookRepo.saveAll(Stream.of(new Book(1,"math"),new Book(2,"physics"),
				new Book(3,"chemistry")).collect(Collectors.toList()));
	}
	
	@GetMapping("/getuser")
	public List<Myuser> getAllUser()
	{
		return myUserRepo.findAll();
	}
	@GetMapping("/getbook")
	public List<Book> getAllBook()
	{
		return bookRepo.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(MultitenancyApplication.class, args);
	}

}
