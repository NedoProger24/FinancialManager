package org.origami.fm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_account")
public class FMUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="username")
    private String username;
    @Column(name ="password")
    private String password;
    @Column(name ="role")
    private String role;
    @Column(name ="email")
    private String email;


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }
}