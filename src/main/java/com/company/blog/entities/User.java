package com.company.blog.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Should not be blank")
    @Size(min = 4,max = 16,message = "name should between 4 to 16 char")
    private String name;

    @Email(message = "Invalid Email")
    @NotEmpty(message = "Should not be blank")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    @NotNull
    private String password;

    @NotEmpty(message = "please provide about")
    @Size(min = 10,max = 150)
    private String about;


//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private List<Post> posts = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "id",
//    referencedColumnName = "id")
    private List<Post> posts;
}
