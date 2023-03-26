package com.srijan.blog.sbblogapp.services.impl;

import com.srijan.blog.sbblogapp.entities.Comment;
import com.srijan.blog.sbblogapp.entities.Post;
import com.srijan.blog.sbblogapp.exceptions.ResourceNotFoundException;
import com.srijan.blog.sbblogapp.payloads.CommentDto;
import com.srijan.blog.sbblogapp.repositories.CommentRepository;
import com.srijan.blog.sbblogapp.repositories.PostRepository;
import com.srijan.blog.sbblogapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment Id", commentId));
        this.commentRepository.delete(comment);
    }
}
