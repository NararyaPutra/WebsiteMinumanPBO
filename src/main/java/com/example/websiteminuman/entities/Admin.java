// package com.example.websiteminuman.entities;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Admin {
//     @Id
//     @GeneratedValue(strategy=GenerationType.AUTO)
//     private Long id;
    
//     @Column(unique=true)
//     private String username;
//     private String password;


//     public Admin() {
//     }
    
//     public Admin(Long id, String username, String password) {
//         this.id = id;
//         this.username = username;
//         this.password = password;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

// }
