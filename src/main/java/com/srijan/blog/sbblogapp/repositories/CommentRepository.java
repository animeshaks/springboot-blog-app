package com.srijan.blog.sbblogapp.repositories;

import com.srijan.blog.sbblogapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {
}
