package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
}









//public class postsDao {
//    public static void save(Post post) {
//    }
//}

//    @PostMapping("/create")
//    public default String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
//        Post post = new Post(title, body);
//        Ad.save(post);
//        return "redirect:/posts";
//    }


