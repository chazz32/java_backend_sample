package levvel.io.controller;

import levvel.io.model.Blog;
import levvel.io.model.Comment;
import levvel.io.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private BlogService blogService;

    @PostMapping("/post")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable String id) {
        Blog blog = blogService.getBlog(id);
        return ResponseEntity.ok().body(blog);
    }

    @PostMapping("/post/{id}/comment")
    public ResponseEntity<Blog> addComment(@PathVariable String id, @RequestBody Comment comment) {
        Blog blog = blogService.getBlog(id);

        if(blog.getComments() == null) {
            ArrayList<Comment> comments = new ArrayList<>();
            comments.add(comment);
            blog.setComments(comments);
        }
        else blogService.addComment(id, comment);

        return ResponseEntity.ok().body(blog);
    }

    @GetMapping("/post/{id}/comment")
    public ResponseEntity<List <Comment>> getComments(@PathVariable String id) {





        Blog blog = blogService.getBlog(id);


        if(blog.getComments() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(blogService.getComments(id));
        }

        return ResponseEntity.ok().body(blogService.getComments(id));
    }


}
