package com.srijan.blog.sbblogapp.services;

import com.srijan.blog.sbblogapp.payloads.PostDto;
import com.srijan.blog.sbblogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    // CREATE
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // UPDATE
    PostDto updatePost(PostDto postDto, Integer postId);

    // DELETE
    void deletePost(Integer postId);

    // GET ALL Posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);

    // GET By Post Id
    PostDto getPostById(Integer postId);

    // GET All Posts By Category
    List<PostDto> getPostsByCategory(Integer categoryId);

    // GET All Posts By User
    List<PostDto> getPostsByUser(Integer userId);

    // Search Posts
    List<PostDto> searchPosts(String keyword);
}
