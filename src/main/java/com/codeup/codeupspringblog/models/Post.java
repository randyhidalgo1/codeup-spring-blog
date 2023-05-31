package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length=100)
    private String title;

    @Column(nullable = false, length=500)
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}















//package com.codeup.codeupspringblog.models;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "posts")
//public class Post {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, length =100)
//    private String title;
//
//    @Column(nullable = false, length =500)
//    private String content;
//
//    public Post() {
//
//    }
//    public Post(String title, String body) {
//        this.title = title;
//        this.content = body;
//    }
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Post(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//}
//
//
////public class Post {
////    private String title;
////    private String body;
////
////    public String getTitle() {
////        return title;
////    }
////
////    public String getBody() {
////        return body;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public void setBody(String body) {
////        this.body = body;
////    }
////}
////
