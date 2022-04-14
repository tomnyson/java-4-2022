/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import io.jsonwebtoken.Claims;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tomnyson
 */
public class Cart {

    ArrayList<Item> cart;
    
    public Cart() {
        this.cart = new ArrayList<Item>();
    }
    
    public boolean add(Item item) {
        try {
            if (cart.contains(item)) {
                // item hien tai
                Item currentItem = cart.get(cart.indexOf(item));
                currentItem.setSoluong(currentItem.getSoluong() + 1);
                // update
            } else {
                cart.add(item);
                // add
            }
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean remove(Item item) {
        try {
            if (cart.contains(item)) {
                // item hien tai
                int vt = cart.indexOf(item);
                cart.remove(vt);
                // update
            }            
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    public float getTongTien() {
       float tongTien =0;
      for(Item item: cart){
          tongTien+=item.getSoluong()*item.getPrice();
      }
      return tongTien;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }
    public int getSize() {
        return cart.size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.cart);
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
        final Cart other = (Cart) obj;
        if (!Objects.equals(this.cart, other.cart)) {
            return false;
        }
        return true;
    }
    
}
