package com.program.models;
public class FoodModel {
    private int id, rating;
    private String nama, deskripsi, gambar;

    public FoodModel() {
        this.id=0;
        this.nama = "";
        this.deskripsi = "";
        this.gambar = "";
        this.rating=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    @Override
    public String toString() {
        return "ItemModel{" + "id=" + id + ", rating=" + rating + ", nama=" +
                nama + ", deskripsi=" + deskripsi + ", gambar=" + gambar + '}';
    }
    
}