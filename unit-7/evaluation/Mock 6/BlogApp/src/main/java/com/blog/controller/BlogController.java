package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.BlogException;
import com.blog.exception.UserException;
import com.blog.model.Blog;
import com.blog.model.Users;
import com.blog.service.BlogService;

import jakarta.validation.Valid;

@RestController
public class BlogController {
	
	
	@Autowired
	private BlogService blogService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	

	@PostMapping("/user")
	public ResponseEntity<Users> saveUsers(@Valid @RequestBody Users user) throws UserException {		
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_"+user.getRole().toUpperCase());
		
		Users savedUsers= blogService.addUser(user);
		
		return new ResponseEntity<Users>(savedUsers,HttpStatus.CREATED);

	}
	
	
	
	@GetMapping("/signIn")
	public ResponseEntity<String> login(Authentication auth) throws UserException{
		
		 Users user = blogService.viewUserByEmail(auth.getName());
		 
		 return new ResponseEntity<>(user.getUsername()+" Logged In Successfully",HttpStatus.ACCEPTED);
		 
	}
	
	
	
	@PutMapping("/user/{email}")
	public ResponseEntity<Users> updateUsers(@Valid @RequestBody Users user, @PathVariable String email) throws UserException {
		
		Users savedUsers= blogService.updateUser(user, email);
		
		return new ResponseEntity<Users>(savedUsers,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/user/{email}")
	public ResponseEntity<Users> updateUsers(@Valid @PathVariable String email) throws UserException {
		
		Users savedUsers= blogService.viewUserByEmail(email);
		
		return new ResponseEntity<Users>(savedUsers,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/blog")
	public ResponseEntity<Blog> addBlog(@Valid @RequestBody Blog blog) throws BlogException {
		
		Blog savedBlog= blogService.createBlog(blog);
		
		return new ResponseEntity<Blog>(savedBlog,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlog(@Valid @RequestBody Blog blog, @PathVariable Integer id) throws BlogException {
		
		Blog savedBlog= blogService.updateBlog(blog, id);
		
		return new ResponseEntity<Blog>(savedBlog,HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/blog/{id}")
	public ResponseEntity<Blog> deleteBlog(@Valid @PathVariable Integer id) throws BlogException {
		
		Blog deletedBlog= blogService.deleteBlogById(id);
		
		return new ResponseEntity<Blog>(deletedBlog,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<Blog> viewBlogById(@Valid @PathVariable Integer id) throws BlogException {
		
		Blog existingBlog= blogService.viewBlogById(id);
		
		return new ResponseEntity<Blog>(existingBlog,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/blogs/{email}")
	public ResponseEntity<List<Blog>> viewAllBlogs(@Valid @PathVariable String email) throws BlogException, UserException {
		
		List<Blog> list = blogService.viewAllBlogs(email);
		
		return new ResponseEntity<List<Blog>>(list,HttpStatus.CREATED);
	}
	
	
}
