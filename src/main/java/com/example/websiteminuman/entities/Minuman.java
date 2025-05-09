package com.example.websiteminuman.entities;

public class Minuman {
    private String nama;
    private String jenis;
    private String ukuran;
    private int harga;
    
    public Minuman(String nama, String jenis, String ukuran, int harga) {
        this.jenis = jenis;
        this.nama = nama;
        this.harga = harga;
        this.ukuran = ukuran;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
}
