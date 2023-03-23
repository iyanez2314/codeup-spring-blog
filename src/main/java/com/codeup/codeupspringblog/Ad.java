package com.codeup.codeupspringblog;
import jakarta.persistence.*;


@Entity
@Table(name ="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;


}



