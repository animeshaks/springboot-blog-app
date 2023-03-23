package com.srijan.blog.sbblogapp.repositories;

import com.srijan.blog.sbblogapp.entities.Category;
import com.srijan.blog.sbblogapp.entities.Post;
import com.srijan.blog.sbblogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
