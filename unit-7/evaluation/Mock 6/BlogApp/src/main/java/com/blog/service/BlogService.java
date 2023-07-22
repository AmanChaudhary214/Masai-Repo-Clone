package com.blog.service;

import java.util.List;

import com.blog.exception.BlogException;
import com.blog.exception.UserException;
import com.blog.model.Blog;
import com.blog.model.Users;

public interface BlogService {
	
	public Users addUser(Users user) throws UserException;
	
	public Users updateUser(Users user, String email) throws UserException;
	
	public Users viewUserByEmail(String Email) throws UserException;
	
	public Blog createBlog(Blog blog) throws BlogException;
	
	public Blog updateBlog(Blog blog, Integer id) throws BlogException;
	
	public Blog deleteBlogById(Integer id) throws BlogException;
	
	public Blog viewBlogById(Integer id) throws BlogException;
	
	public List<Blog> viewAllBlogs(String email) throws BlogException, UserException;
	
}
