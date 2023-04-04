package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 255)
    private String body;

//    This will help us reference the users in the post that was created
    // This is similar to doing FOREIGN KEY (user_id) REFERENCES user (id)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public long getId() {
        return id;
    }
}
