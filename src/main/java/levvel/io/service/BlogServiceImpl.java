package levvel.io.service;

import levvel.io.data.BlogRepository;
import levvel.io.model.Blog;
import levvel.io.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(String id) {
        return blogRepository.findById(id).orElseGet(null);
    }

    @Override
    public void addComment(String id, Comment comment) {

        Blog blog = blogRepository.findById(id).orElseGet(null);

        blog.addComms(id, comment);
        blogRepository.save(blog);
    }

    @Override
    public List<Comment> getComments(String id) {
        return blogRepository.findById(id).orElseGet(null).getcomms();
    }
}
