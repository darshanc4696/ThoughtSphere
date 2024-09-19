package com.blog.dao;

import com.blog.model.User;

public interface UserDAO 
{
	int addUser(User user);
	User fetchUser(String email);
}
