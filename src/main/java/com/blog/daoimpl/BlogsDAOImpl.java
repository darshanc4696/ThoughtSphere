package com.blog.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.BlogsDAO;
import com.blog.model.Blogs;
import com.blog.utils.MyConnection;

public class BlogsDAOImpl implements BlogsDAO
{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	private static final String ADD_BLOG = "insert into blogs(userId, title, content) values(?,?,?)";
	private static final String FETCH_ALLBLOGS = "select * from blogs";
	private static final String FETCH_BLOG = "select * from blogs where userId = ?";
	private static final String FETCH_BLOG_ONID = "select * from blogs where blogId = ?";
	private static final String UPDATE_BLOG = "update blogs set title=? content=? where blogId = ?";
	private static final String DELETE_BLOG = "delete from blogs where blogId = ?";
	
	ArrayList<Blogs> blogsList = new ArrayList<Blogs>();
	private Statement stmt;
	private ResultSet resultSet;
	
	public BlogsDAOImpl()
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addBlog(Blogs blog) 
	{
		try 
		{
			pstmt = connection.prepareStatement(ADD_BLOG);
			pstmt.setInt(1, blog.getUserId());
			pstmt.setString(2, blog.getTitle());
			pstmt.setString(3, blog.getContent());
			
			status = pstmt.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Blogs> fetchAllBlogs() 
	{
		try 
		{
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(FETCH_ALLBLOGS);
			blogsList = extractBlogsFromResultSet(resultSet);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return blogsList;
	}

	private ArrayList<Blogs> extractBlogsFromResultSet(ResultSet resultSet2) 
	{
		try 
		{
			while(resultSet.next())
			{
				blogsList.add(new Blogs(resultSet.getInt("blogId"),
						resultSet.getInt("userId"),
						resultSet.getString("title"),
						resultSet.getString("content"),
						resultSet.getString("publishedAt"),
						resultSet.getString("imgPath")
						));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		return blogsList;
	}

	@Override
	public List<Blogs> fetchSpecificBlogs(int userId) 
	{
		try 
		{
			pstmt = connection.prepareStatement(FETCH_BLOG);
			pstmt.setInt(1, userId);
			
			resultSet = pstmt.executeQuery();
			blogsList = extractBlogsFromResultSet(resultSet);
			
		} 
		catch (Exception e) 
		{
			
		}
		return blogsList;
	}
	
	
	@Override
	public Blogs fetchSpecificBlogsOnBlogId(int blogId) 
	{
		blogsList.clear();
		try 
		{
			pstmt = connection.prepareStatement(FETCH_BLOG_ONID);
			pstmt.setInt(1, blogId);
			
			resultSet = pstmt.executeQuery();
			blogsList = extractBlogsFromResultSet(resultSet);
			
		} 
		catch (Exception e) 
		{
			
		}
		return blogsList.get(0);
	}

	@Override
	public int updateSpecificBlog(Blogs blog) 
	{
		try 
		{
			pstmt = connection.prepareStatement(UPDATE_BLOG);
			pstmt.setString(1, blog.getTitle());
			pstmt.setString(2, blog.getContent());
			pstmt.setInt(3, blog.getBlogId());
			
			status = pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteSpeicficBlog(int blogId) 
	{
		try 
		{
			pstmt = connection.prepareStatement(DELETE_BLOG);
			pstmt.setInt(1, blogId);
			
			status = pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}

}
