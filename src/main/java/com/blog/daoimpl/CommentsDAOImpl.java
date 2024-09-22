package com.blog.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.CommentsDAO;
import com.blog.model.Comments;
import com.blog.utils.MyConnection;

public class CommentsDAOImpl implements CommentsDAO
{
	
	private Connection connection;
	private PreparedStatement pstmt;
	private int status;
	private static final String ADD_COMMENT = "insert into comments(blogId, userId, commentText) values(?,?,?)";
	private static final String FETCH_COMMENT = "select * from comments where blogId = ?";

	ArrayList<Comments> commentList = new ArrayList<Comments>();
	private ResultSet resultSet;
	
	
	public CommentsDAOImpl()
	{
		connection = MyConnection.myConnect();
	}

	@Override
	public int addComment(Comments comment) 
	{
		try 
		{
			pstmt = connection.prepareStatement(ADD_COMMENT);
			pstmt.setInt(1, comment.getBlogId());
			pstmt.setInt(2, comment.getUserId());
			pstmt.setString(3, comment.getCommentText());
			
			status = pstmt.executeUpdate();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Comments> fetchSpecificComments(int blogId) 
	{
		try 
		{
			pstmt = connection.prepareStatement(FETCH_COMMENT);
			pstmt.setInt(1, blogId);
			
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next())
			{
				commentList.add(new Comments(resultSet.getInt("commentId"),
						resultSet.getInt("blogId"),
						resultSet.getInt("userId"),
						resultSet.getString("commentText"),
						resultSet.getString("commentedAt")
						));
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return commentList;
	}
	

}
