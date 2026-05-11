/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdl.ujian;

/**
 *
 * @author puspa
 */
public class MyItem {

    private String data;
    private int numbers;
    public MyItem() {}
    public MyItem(String data, int numbers) {
        this.data = data;
        this.numbers = numbers;
    }
    // Method untuk mengubah data
    public void setData(String data) {
        this.data = data;
    }
    // Method untuk mengubah numbers
    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
    // Method untuk mengambil data
    public String getData() {
        return data;
    }
    // Method untuk mengambil numbers
    public int getNumbers() {
        return numbers;
    }
    // Method untuk mengubah object menjadi String
    public String toString() {
        return data + " = " + numbers;
    }
    // Method untuk membandingkan object
    public boolean equals(Object obj) {
        // Jika object berupa String
        if (obj instanceof String) {
            // Membandingkan hasil toString dengan String
            return this.toString().equals(obj);
        }
        // Jika object berupa MyItem
        if (obj instanceof MyItem) {
            // Casting object menjadi MyItem
            MyItem other = (MyItem) obj;
            // Membandingkan data dan numbers
            return data.equals(other.data) && numbers == other.numbers;
        }
        return false;
    }
}
