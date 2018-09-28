package com.sit.cloudnative.PostService.Post;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.sit.cloudnative.PostService.UserAdapter.User;
import com.sit.cloudnative.PostService.UserAdapter.UserAdapter;

// import com.sit.cloudnative.PostService.User.UserRepository;
// import com.sit.cloudnative.PostService.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;
  
    @Autowired 
    private UserAdapter userAdapter;
    // @Autowired
    // public PostController(PostRepository postRepository,UserAdapter userAdapter){
    // this.postRepository=postRepository;
    // this.userAdapter=userAdapter;

    // }

    // // Get All Post
    @GetMapping("/posts")
    public ResponseEntity<List<AllList>> getAllPostList() {
      List<Post> posts = postService.getAllPosts();
      List<AllList> allList = new ArrayList<AllList>();
      for (Post post: posts) {
        User user = userAdapter.getUserDetail(post.getUserId());
        allList.add(new AllList(
          post.getId(),
          post.getTitle(),
          post.getDescription(),
          user,
          post.getComment(),
          post.getCreatedAt()
        ));
      }
      return new ResponseEntity<List<AllList>>(allList,HttpStatus.OK);
    }

    // Create a new Post
    @PostMapping("/post/{userId}")
    public ResponseEntity<Post> postNewPost(@PathVariable long userId, @RequestBody Post post) {
        post.setUserId(userId);
        Post postObject = postService.savePost(post);
        return new ResponseEntity<Post>(postObject, HttpStatus.OK);
    }

    // Get Post By Id

    // // Get a Single Post
    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable long postId) {
        Post post = postService.getPostById(postId);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }
}
