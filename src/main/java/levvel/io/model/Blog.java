package levvel.io.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Blog {

    @Id
    String id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public List<Comment> getcomms()
    {
        return this.comments;
    }

    public void addComms(String id, Comment com)

    {

        List<Comment> vals = new ArrayList<>();
        vals.add(com);
        vals.addAll(this.comments);
        this.comments = vals;
    }

    String author;
    String title;
    String text;
    List<Comment> comments;
}
