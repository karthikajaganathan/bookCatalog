package com.example.book.exception;

import java.util.Set;

public class BookUnSupportFieldPatchException extends RuntimeException{

	public static final long serialVersionUID =1L;
	
	public BookUnSupportFieldPatchException(Set<String> keys)
	{
		super("Field" + keys.toString()+ "update is not allow.");
	}
}
