package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.controller.AdminController;
import com.capgemini.librarymanagementsystem.controller.UserControllerDetails;

public class LibrarianDaoImpl implements LibrarianDao {

	public boolean login(String userName, String password) {

		try {

			if ((userName.equals("Admin")) && (password.equals("admin123"))) {
				System.out.println("Admin SuccessFully Login");
                AdminController.adminMain();
				return true;
			} else if ((userName.equals("User")) && (password.equals("user123"))) {
				System.out.println("User SuccessFully Login");
				UserControllerDetails.userMain1();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("::::: Username and password is wrong :( ::::: ");
			return false;
		}

	}
}
