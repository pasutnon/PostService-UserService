package com.sit.cloudnative.PostService.Comment;

import java.util.List;

import javax.validation.Valid;

import com.sit.cloudnative.PostService.Post.PostRepository;
// import com.sit.cloudnative.PostService.User.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(@Valid Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getByPostId(long id) {
        return commentRepository.findByPostId(id);
    }

    // public Comment getCommentById(Long commentId) {
    // return commentRepository.findById(commentId).orElseThrow(() -> new
    // ResourceNotFoundException("Comment", "id", commentId));
    // }
}