package repositories;
import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface PostsRepository extends JpaRepository<Post, Long> {
    Post findById(long id);

public class postsDao {
    public static void save(Post post) {
    }
}

//    @PostMapping("/create")
//    public default String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
//        Post post = new Post(title, body);
//        Ad.save(post);
//        return "redirect:/posts";
//    }

}
