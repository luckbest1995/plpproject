package com.capgemini.librarymanagementsystem.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.librarymanagementsystem.bean.BookDetails;
import com.capgemini.librarymanagementsystem.bean.UserBean;
import com.capgemini.librarymanagementsystem.exception.BookException;

public class BookDetailsDaoImpl implements BookDetailsDao {

	private static HashMap<Integer, BookDetails> h1 = new HashMap<Integer, BookDetails>();
	static int bookId = 0;


	public void showAllBook() {
		if(h1.isEmpty()==false) {
			System.out.println("                            ::::ALL USER DETAILS::::");
			Set<Integer> s=h1.keySet();
			for (Integer key : s) {
				BookDetails cb=h1.get(key);
				System.out.println("book-ID: "+key);
				System.out.println(cb);
			}
		}else {
			System.err.println("Currently there is no user..");
		}
	}

	public boolean updateBook(int bookId, BookDetails books) {
		if (h1.replace(bookId, books) != null) {
			return true;
		} else {
			throw new BookException("this book Not Found, Problem in updating try again..!");
		}
	}

	public boolean deleteBook(int bookId) {
		if (h1.remove(bookId) != null) {
			return true;
		} else {
			throw new BookException("Book Not Found..!");
		}
	}

	public boolean addBook(BookDetails books) {
		while (true) {
			++bookId;

			books.setBookId(bookId);
			try {
				h1.put(bookId, books);
				return true;
			} catch (Exception e) {
				throw new BookException("Duplicate book ID, please try again..!");
			}
		}
	}

	public BookDetails searchBook(int bookId) {
		if (h1.containsKey(bookId) == true) {
			return h1.get(bookId);
		} else {
			System.err.println("No such book Exist..!");
			return null;
		}
	}

}
