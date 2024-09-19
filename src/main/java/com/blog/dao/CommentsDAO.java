package com.blog.dao;

import java.util.List;

import com.blog.model.Comments;

public interface CommentsDAO 
{
	int addComment(Comments comment);
	List<Comments> fetchSpecificComments(int blogId);

}
