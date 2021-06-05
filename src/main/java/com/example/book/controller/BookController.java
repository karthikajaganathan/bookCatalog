package com.example.book.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.entities.Book;
import com.example.book.exception.BookNotFoundException;
import com.example.book.exception.BookUnSupportFieldPatchException;
import com.example.book.repository.BookRepository;


@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
//	private BookService bookService;
	
	@PostMapping("/books")
	@ResponseStatus(HttpStatus.CREATED)
	public Book createBook(@RequestBody Book book)
	{
		return book;


	}
	
	@PutMapping("/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id)
	{
		return bookRepository.findById(id).map(x -> {
		x.setAuthorName(book.getAuthorName());
		x.setTitle(book.getTitle());
		x.setDate(book.getDate());
		return bookRepository.save(x);
		}).orElseGet(()-> {
			book.setBookId(id);
			return bookRepository.save(book);
		});
		
	}
	
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable Long id)
	{
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
	}

	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return (List<Book>) bookRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@PatchMapping("/books/{id}")
	public Book updateBookAuthor(@RequestBody Map<String, String> map, @PathVariable Long id)
	{

		return bookRepository.findById(id).map(x -> {

			String author = map.get("author");
			if (!StringUtils.isEmpty(author))
			{
				x.setAuthorName(author);

				return bookRepository.save(x);
			}
			else
			{
				throw new BookUnSupportFieldPatchException(map.keySet());
			}

		}).orElseGet(() -> {
			throw new BookUnSupportFieldPatchException(null);
		});

	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable Long id)
	{
		bookRepository.deleteById(id);
	}

	
//	public void setBookService(BookService bookService) {
//		this.bookService=bookService;
//		}
//	
//	@GetMapping("/{bookId}")
//	public void getBookdetails(@PathVariable("books") Integer bookId) {
//		this.bookService.getbookbyId(bookId);    
//		}
//	
////	@GetMapping("book/{bookid}")
////	    public String showBook(@PathVariable Integer bookid, Model model) {
////	        model.addAttribute("book",bookService.getbookbyId(bookid) );
////	        return "bookShow";
////	    }
//  /*@GetMapping("book/edit/{bookid}")
//	    public String edit(@PathVariable Integer bookid, Model model) {
//	       // model.addAttribute("bookid");
//	       model.addAttribute("book", bookService.getbookbyId(bookid));
//	        return "BookDetails";
//	    }
//
//
// @RequestMapping("book/new")
//	    public String newBook(Model model) {
//	        model.addAttribute("book", new Book());
//	        return "newBook";
//	    }
//	  
//	  
//	  @RequestMapping(value = "book")
//	  @PostMapping("/{bookId}")
//	    public String saveBook(Book book) {
//	        Bookservice.updateBook(book);
//	        return "redirect:/book/" + book.getBookId();
//	    } */
//
//
//	

}
