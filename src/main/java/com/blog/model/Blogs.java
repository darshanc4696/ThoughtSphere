package com.blog.model;

public class Blogs 
{
	private int blogId;
	private int userId;
	private String title;
	private String content;
	private String publishedAt;
	private String imgPath;
	
	public Blogs() {
		super();
	}

	public Blogs(int blogId, int userId, String title, String content, String publishedAt, String imgPath) {
		super();
		this.blogId = blogId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.publishedAt = publishedAt;
		this.imgPath = imgPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Blogs(int userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	@Override
	public String toString() {
		return "Blogs [blogId=" + blogId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", publishedAt=" + publishedAt + "]";
	}

}
