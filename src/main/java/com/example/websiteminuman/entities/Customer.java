package com.example.websiteminuman.entities;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    protected ArrayList<Minuman> M;
    protected ArrayList<History> H;
    protected ArrayList<Payment> P;

    public Customer() {
    }    
    
    public Customer(String password, String email) {
        this.password = password;
        this.email = email;
        this.M = new ArrayList<>();
        this.H = new ArrayList<>();
        this.P = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void AddToCart(Minuman minuman) {
        if (minuman != null) {
            M.add(minuman);
            System.out.println("Minuman " + minuman.getNama() + " ditambahkan ke keranjang.");
        } else {
            System.out.println("Minuman tidak boleh null.");
        }
    }

    // public void OrderMinuman(String nama, String jenis, String ukuran, int harga) {
    //     Minuman minumanBaru = new Minuman(nama, jenis, ukuran, harga);
    //     AddToCart(minumanBaru);
    // }

    // @Override
    // public void login() {
    //     if (email == null || email.isEmpty()) {
    //         System.out.println("Email tidak boleh kosongs.");
    //         return;
    //     } else if (getPassword() == null || getPassword().isEmpty()) {
    //         System.out.println("Password tidak boleh kosong.");
    //         return;
    //     } else {
    //         System.out.println("Login berhasil.");
    //     }
    //     System.out.println("Customer " + email + " logged in.");
    // }
}
