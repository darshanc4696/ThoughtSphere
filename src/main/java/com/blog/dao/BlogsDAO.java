package com.blog.dao;

import java.util.List;

import com.blog.model.Blogs;

public interface BlogsDAO 
{
	int addBlog(Blogs blog);
	List<Blogs> fetchAllBlogs();
	List<Blogs> fetchSpecificBlogs(int userId);
	int updateSpecificBlog(Blogs blog);
	int deleteSpeicficBlog(int blogId);

}
