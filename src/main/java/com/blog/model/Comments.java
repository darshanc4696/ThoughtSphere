package com.blog.model;

public class Comments 
{
	private int commentId;
	private int blogId;
	private int userId;
	private String commentText;
	private String commentedAt;
	public Comments() {
		super();
	}
	
	public Comments(int commentId, int blogId, int userId, String commentText, String commentedAt) {
		super();
		this.commentId = commentId;
		this.blogId = blogId;
		this.userId = userId;
		this.commentText = commentText;
		this.commentedAt = commentedAt;
	}
	
	public Comments(int blogId, int userId, String commentText) {
		super();
		this.blogId = blogId;
		this.userId = userId;
		this.commentText = commentText;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public String getCommentedAt() {
		return commentedAt;
	}

	public void setCommentedAt(String commentedAt) {
		this.commentedAt = commentedAt;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", blogId=" + blogId + ", userId=" + userId + ", commentText="
				+ commentText + ", commentedAt=" + commentedAt + "]";
	}
	
}
