package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
