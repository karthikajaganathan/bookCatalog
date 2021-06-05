package com.example.book.exception;



public class BookNotFoundException extends RuntimeException
 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException(Long id) 	{
		super("Match not Found"+id);
	}
	
}
