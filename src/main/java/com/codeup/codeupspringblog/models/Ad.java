package com.codeup.codeupspringblog.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ad {
    @Id
    private long id;
    private String title;
    private String description;

    public static void save(Post post) {

    }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ad(){}

    public void setId(Long id) {
        this.id = id;
    }

}
