package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.BlogException;
import com.blog.exception.UserException;
import com.blog.model.Blog;
import com.blog.model.Users;
import com.blog.repository.BlogRepository;
import com.blog.repository.UserRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository br;
	
	@Autowired 
	private UserRepository ur;
	
	
	
	@Override
	public Blog createBlog(Blog blog) throws BlogException {
		
		if (blog == null) {
			throw new BlogException("Blog can't be null");
		}

		Optional<Blog> existingBlog = br.findById(blog.getId());
		
		if(existingBlog.isPresent()) 
			throw new BlogException("Blog already exists with given blogId");
		
		br.save(blog);
		
		return blog;
	}
	
	

	@Override
	public Blog updateBlog(Blog blog, Integer id) throws BlogException {

		if (blog == null) {
			throw new BlogException("Blog can't be null");
		}

		Optional<Blog> existingBlog = br.findById(id);
		
		if(existingBlog.isEmpty()) 
			throw new BlogException("Blog doesn't exists with given blogId");
		
		br.save(blog);
		return blog;
	}
	
	

	@Override
	public Blog deleteBlogById(Integer id) throws BlogException {

		if (id.equals(null)) {
			throw new BlogException("Blog can't be null");
		}

		Optional<Blog> existingBlog = br.findById(id);
		
		if(existingBlog.isEmpty()) 
			throw new BlogException("Blog doesn't exists with given blogId");
		
		br.delete(existingBlog.get());
		return existingBlog.get();
	}
	

	
	@Override
	public Blog viewBlogById(Integer id) throws BlogException {

		if (id.equals(null)) {
			throw new BlogException("Blog can't be null");
		}
		
		Optional<Blog> existingBlog = br.findById(id);
		
		if(!existingBlog.isPresent()) 
			throw new BlogException("Blog doesn't exists with given blogId");
		
		return existingBlog.get();
	}
	
	

	@Override
	public List<Blog> viewAllBlogs(String email) throws BlogException, UserException {
		
		Optional<Users> us = ur.findByEmail(email);
		
    	if(us.isEmpty()) {
    		throw new UserException("null vallue") ;
    	}
    	
    	if(us.get().getBlogs().isEmpty()) {
    		throw new BlogException("Empty blog list") ;
    	}
    	
    	return us.get().getBlogs() ;
	}


	
	@Override
	public Users addUser(Users user) throws UserException {

		if(user == null) {
    		throw new UserException("Customer is null") ; 
    	}
    	
    	Optional<Users> us = ur.findByEmail(user.getEmail()) ;
    	if(us.isPresent()) {
    		throw new UserException("User already present in database") ;
    	}
    	
    	return ur.save(user) ;
	}


	
	@Override
	public Users updateUser(Users user, String email) throws UserException {
		
		if(user == null) {
    		throw new UserException("Customer is null"); 
    	}
    	
    	Optional<Users> us = ur.findByEmail(email);
    	if(!us.isPresent()) {
    		throw new UserException("User not found in database") ;
    	}
    	
    	return ur.save(user) ;
	}


	
	@Override
	public Users viewUserByEmail(String email) throws UserException {

		if(email == null) {
    		throw new UserException("Email is null"); 
    	}
    	
    	Optional<Users> us = ur.findByEmail(email);
    	if(!us.isPresent()) {
    		throw new UserException("User not found in database") ;
    	}
    	
    	return us.get();
	}

}
