package com.sit.cloudnative.PostService.Comment;

import java.util.List;

import javax.validation.Valid;

import com.sit.cloudnative.PostService.Post.Post;
import com.sit.cloudnative.PostService.Post.PostRepository;
// import com.sit.cloudnative.PostService.User.UserRepository;
import com.sit.cloudnative.PostService.Post.PostService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    // @Autowired
    // private UserAdapter userAdapter;

    @GetMapping("/comment/{postId}")
    public ResponseEntity<List<Comment>> getCommentByPostId(@PathVariable long postId) {
        List<Comment> comment = commentService.getByPostId(postId);
        return new ResponseEntity<List<Comment>>(comment, HttpStatus.OK);
    }

    @PostMapping("/comment/{postId}/{userId}")
    public ResponseEntity<Comment> createComment(@PathVariable long postId, @PathVariable long userId,
            @RequestBody Comment comment) {
        Post post = postService.getPostById(postId);
        // User user = userAdapter.getUserDetail(userId);
        comment.setPost(post);
        comment.setUserId(userId);
        Comment commentObject = commentService.createComment(comment);
        return new ResponseEntity<Comment>(commentObject, HttpStatus.OK);
    }
}