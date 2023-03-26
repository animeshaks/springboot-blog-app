package com.srijan.blog.sbblogapp.services;

import com.srijan.blog.sbblogapp.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);
    void deleteComment(Integer commentId);
}
