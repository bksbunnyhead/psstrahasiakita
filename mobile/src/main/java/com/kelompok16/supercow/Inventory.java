package com.kelompok16.supercow;

/**
 * Created by Dandu on 2/21/17.
 */

public class Inventory {
    private int quantity;

    public void plusQuan(){
        quantity++;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
