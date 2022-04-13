/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author tomnyson
 */
public class Item {
    int maSP;
    int soluong;
    String title;
    float price;
    String image;

    public Item(int maSP, int soluong, String title, float price, String image) {
        System.out.println("call here");
        this.maSP = maSP;
        this.soluong = soluong;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public int getMaSP() {
        return maSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.maSP;
        hash = 47 * hash + this.soluong;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Float.floatToIntBits(this.price);
        hash = 47 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.maSP != other.maSP) {
            return false;
        }
        return true;
    }
    
    
}
