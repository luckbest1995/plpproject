package com.capgemini.librarymanagementsystem.dao;

import java.util.HashMap;
import java.util.Set;

import com.capgemini.librarymanagementsystem.bean.UserBean;
import com.capgemini.librarymanagementsystem.exception.BookException;

public class UserDaoImpl implements UserDao {

	private static HashMap<Integer, UserBean> h1 = new HashMap<Integer, UserBean>();
	static int userId = 0;
	
	public void showAllUser() {
		if(h1.isEmpty()==false) {
			System.out.println("                            ::::ALL USER DETAILS::::");
			Set<Integer> s=h1.keySet();
			for (Integer key : s) {
				UserBean cb=h1.get(key);
				System.out.println("User-ID: "+key);
				System.out.println(cb);
			}
		}else {
			System.err.println("Currently there is no user..");
		}
	}

//	public HashMap<Integer, UserBean> getAllUser() {
//		if (h1.isEmpty() == false) {
//			return h1;
//		} else {
//			return null;
//		}
//	}

	public boolean updateUser(int userId, UserBean password) {
		try{
			if(h1.containsKey(userId)) {
				h1.replace(userId,password );
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.err.println("There is problem in Updation..!");
			return false;
		}
	}

	public boolean deleteUser(int userId) {
		if (h1.remove(userId) != null) {
			return true;
		} else {
			throw new BookException("User Not Found..!");
		}
	}

	public boolean addUser(UserBean user) {
		while (true) {
			++userId;

			user.setUserId(userId);
			try {
				h1.put(userId, user);
				return true;
			} catch (Exception e) {
				throw new BookException("Duplicate User ID, please try again..!");
			}
		}
	}

	public UserBean searchUser(int userId) {
		if (h1.containsKey(userId) == true) {
			return h1.get(userId);
		} else {
			System.err.println("No such User Exist..!");
			return null;
		}
	}

}
