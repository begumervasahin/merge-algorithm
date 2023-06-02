package com.example.mongodb.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.validation.BindingResult;
import com.example.mongodb.model.Book;
import com.example.mongodb.repo.Bookrepo;

@Controller
public class ControlEkran {
	@Autowired
	private Bookrepo repo;
	

@GetMapping("/index")
public String ViewForm(Model model)
{
model.addAttribute("Book", new Book());
return "index";
}


@PostMapping("/book")
public String addForm(@ModelAttribute Book book,BindingResult result,Model model)
{
	repo.save(book);
book.setBirlesmisSon(book.Total());
book.setSure(book.getSure());
model.addAttribute("book",book);
repo.save(book);
return "second";
}




/*
@PostMapping("/addbook")
public String addForm(@ModelAttribute Book book,BindingResult result,Model model)
{
model.addAttribute("addbook",addbook);
return "second";
}

	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
       repo.save(book);
	return " kitap eklendi : "+book.getId();
	}
	
	@GetMapping("/findAllBooks")
	public List<Book> getBooks(){
		return repo.findAll();
	}
	
	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repo.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repo.deleteById(id);
		return "book deleted with id : " + id;
	}
	*/
}
