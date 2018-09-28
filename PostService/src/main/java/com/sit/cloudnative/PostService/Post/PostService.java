package com.sit.cloudnative.PostService.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(long id) {
        return postRepository.findById(id).get();
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    // public Post getPostById(Long postId) {
    // return postRepository.findById(postId).orElseThrow(() -> new
    // ResourceNotFoundException("Post", "id", postId));
    // }
}