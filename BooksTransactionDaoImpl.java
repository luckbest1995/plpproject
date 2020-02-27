package com.capgemini.librarymanagementsystem.dao;

import java.util.HashMap;

import com.capgemini.librarymanagementsystem.bean.BooksTransaction;
import com.capgemini.librarymanagementsystem.exception.BookException;

public class BooksTransactionDaoImpl implements BooksTransactionDao {

	private static HashMap<Integer, BooksTransaction> h1 = new HashMap<Integer, BooksTransaction>();
	static int transactionId = 0;

	public HashMap<Integer, BooksTransaction> getAllTrans() {
		if (h1.isEmpty() == false) {
			return h1;
		} else {
			return null;
		}
	}

	public boolean updateTransaction(int transactionId, BooksTransaction books) {
		if (h1.replace(transactionId, books) != null) {
			return true;
		} else {
			throw new BookException(" This book transaction Not Found, Problem in updating try again..!");
		}
	}

	public boolean deleteTransaction(int transactionId) {
		if (h1.remove(transactionId) != null) {
			return true;
		} else {
			throw new BookException("This Book transaction Not Found..!");
		}
	}

	public boolean addTransaction(BooksTransaction books) {
		while (true) {
			++transactionId;

			books.setRegistrationId(transactionId);
			try {
				h1.put(transactionId, books);
				return true;
			} catch (Exception e) {
				throw new BookException("Duplicate transaction ID, please try again..!");
			}
		}
	}

	public BooksTransaction searchTransaction(int transactionId) {
		if (h1.containsKey(transactionId) == true) {
			return h1.get(transactionId);
		} else {
			System.err.println("No such transaction Exist..!");
			return null;
		}
	}

}
