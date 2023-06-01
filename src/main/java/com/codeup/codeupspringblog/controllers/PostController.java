package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Category;
import com.codeup.codeupspringblog.models.Comment;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CategoryRepository;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codeup.codeupspringblog.repositories.PostsRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PostController {
    private PostsRepository postsDao;
    private UserRepository usersDao;
    private CommentRepository commentsDao;
    private CategoryRepository categoriesDao;

    public PostController(PostsRepository postsDao, UserRepository usersDao, CommentRepository commentsDao, CategoryRepository categoriesDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.commentsDao = commentsDao;
        this.categoriesDao = categoriesDao;
    }

    public Set<Category> makeCategorySet(String categoriesCsl) {
        Set<Category> categoryObjects = new HashSet<>();
        if (categoriesCsl.equals("")) {
            return categoryObjects;
        }
        for (String category : categoriesCsl.split(",")) {
            Category categoryObject = new Category(category.trim());
            categoryObjects.add(categoryObject);
        }
        return categoryObjects;
    }

    @GetMapping("/posts")
    public String allPosts(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/creator-of-posts")
    public String createForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitForm(@RequestParam(name="title") String title, @RequestParam(name="body") String body, @RequestParam(name="categories") String categories) {
        User user = usersDao.findUserById(1L);
        Post post = new Post(title, body, user);
        Set<Category> categorySet = makeCategorySet(categories);
        if (categorySet.size() > 0){
            List<Category> categoriesToAdd = new ArrayList<>();
            for (Category category : categorySet){
                Category categoryFromDb = categoriesDao.findCategoryByName(category.getName());
                if (categoryFromDb == null){
                    categoriesToAdd.add(category);
                } else {
                    categoriesToAdd.add(categoryFromDb);
                }
            }
            categorySet.clear();
            categorySet.addAll(categoriesToAdd);
            post.setCategories(categorySet);
        }
        postsDao.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/comment")
    public String submitComment (@RequestParam(name="content") String content, @RequestParam(name="postId") long postId) {
        Post post = postsDao.findById(postId);
        User user = usersDao.findUserById(1L);
        Comment comment = new Comment(content, post, user);
        commentsDao.save(comment);
        return "redirect:/posts";
    }

    public PostsRepository getPostsDao() {
        return postsDao;
    }

    public void setPostsDao(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    public UserRepository getUsersDao() {
        return usersDao;
    }
    public void setUsersDao(UserRepository usersDao) {
        this.usersDao = usersDao;
    }
    public CommentRepository getCommentsDao() {
        return commentsDao;
    }
    public void setCommentsDao(CommentRepository commentsDao) {
        this.commentsDao = commentsDao;
    }
    public CategoryRepository getCategoriesDao() {
        return categoriesDao;
    }
    public void setCategoriesDao(CategoryRepository categoriesDao) {
        this.categoriesDao = categoriesDao;
    }
}
















//package com.codeup.codeupspringblog.controllers;
//import repositories.PostsRepository;
//
//import com.codeup.codeupspringblog.models.Post;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class PostController {
//    private final PostsRepository postsDao;
//
//    public PostController(PostsRepository postsDao){
//        this.postsDao = postsDao;
//    }
//
//
//    @GetMapping("/posts")
//    public String listPosts(Model model) {
//        List<Post> posts = postsDao.findAll();
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }
//    @GetMapping("/posts/{id}")
//    public String showPost(@PathVariable Long id, Model model) {
//        Post post = postsDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
//        model.addAttribute("post", post);
//        return "posts/show";
//    }
//    @GetMapping("/creator-of-posts")
//    public String createPost(){
//        return "/posts/create";
//    }
//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam String title, @RequestParam String content) {
//        Post post = new Post(title, content);
//        postsDao.save(post);
//        return "redirect:/posts";
//    }
//
//
//
//
//}
//
//
//
//
//
////@Controller
////public class PostController {
////    @GetMapping("/posts")
////    public String allPosts(Model model) {
////        List<Post> posts = new ArrayList<>();
////        Post post1 = new Post();
////        post1.setTitle("First Post");
////        post1.setBody("This is the first post.");
////        posts.add(post1);
////
////        Post post2 = new Post();
////        post2.setTitle("Second Post");
////        post2.setBody("This is the second post.");
////        posts.add(post2);
////
////        model.addAttribute("posts", posts);
////        return "posts/index";
////    }
////
////    @GetMapping("/posts/{id}")
////    public String individualPost(@PathVariable int id, Model model) {
////        Post post = new Post();
////        post.setTitle("Post " + id);
////        post.setBody("This is the post with id " + id + ".");
////        model.addAttribute("post", post);
////        return "posts/show";
////    }
////
////    @GetMapping("/posts/create")
////    public String createPosts() {
////        return "posts/create";
////    }
////
////    @PostMapping("/posts/create")
////    public String submitPosts() {
////        // Logic for creating a new post
////        return "redirect:/posts";
////    }
////}
//
//
