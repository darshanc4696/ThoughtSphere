package com.blog.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blog.dao.UserDAO;
import com.blog.model.User;
import com.blog.utils.MyConnection;

public class UserDAOImpl implements UserDAO 
{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	private ResultSet resultSet;
	private static final String ADD_User = "insert into user(username, email, phoneNumber, password, address) values(?,?,?,?,?)";
	private static final String Fetch_User = "select * from user where email = ?";

	ArrayList<User> userList = new ArrayList<User>();
	
	public UserDAOImpl()
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addUser(User user) 
	{
		try 
		{
			pstmt = connection.prepareStatement(ADD_User);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			
			status = pstmt.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public User fetchUser(String email) 
	{
		try 
		{
			pstmt = connection.prepareStatement(Fetch_User);
			pstmt.setString(1, email);
			
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				userList.add(new User(resultSet.getString("username"),
						resultSet.getString("password"),
						resultSet.getString("email"),
						resultSet.getString("phoneNumber"),
						resultSet.getString("address")
						));
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return userList.get(0);
	}

}
