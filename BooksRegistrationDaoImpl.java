package com.capgemini.librarymanagementsystem.dao;

import java.util.HashMap;

import com.capgemini.librarymanagementsystem.bean.BookDetails;
import com.capgemini.librarymanagementsystem.bean.BooksRegistration;
import com.capgemini.librarymanagementsystem.exception.BookException;

public class BooksRegistrationDaoImpl implements BooksRegistrationDao {

	private static HashMap<Integer, BooksRegistration> h1 = new HashMap<Integer, BooksRegistration>();
	static int registrationId = 0;

	public HashMap<Integer, BooksRegistration> getAllInfo() {
		if (h1.isEmpty() == false) {
			return h1;
		} else {
			return null;
		}
	}

	public boolean updateRegistration(int registrationId, BooksRegistration books) {
		if (h1.replace(registrationId, books) != null) {
			return true;
		} else {
			throw new BookException(" This book Registration Not Found, Problem in updating try again..!");
		}
	}

	public boolean deleteRegistration(int registrationId) {
		if (h1.remove(registrationId) != null) {
			return true;
		} else {
			throw new BookException("This Book Registration Not Found..!");
		}
	}

	public boolean addRegistration(BooksRegistration books) {
		while (true) {
			++registrationId;

			books.setRegistrationId(registrationId);
			try {
				h1.put(registrationId, books);
				return true;
			} catch (Exception e) {
				throw new BookException("Duplicate Registration ID, please try again..!");
			}
		}
	}

	public BooksRegistration searchRegistration(int registrationId) {
		if (h1.containsKey(registrationId) == true) {
			return h1.get(registrationId);
		} else {
			System.err.println("No such Registration Exist..!");
			return null;
		}
	}

}
