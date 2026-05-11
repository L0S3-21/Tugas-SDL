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
public class MyItemMap {

    // Array untuk menyimpan object MyItem
    private MyItem[] data;

    // Constructor kosong
    public MyItemMap() {}

    // Constructor dengan parameter size
    public MyItemMap(int size) {
        data = new MyItem[size];
    }

    // Setter data
    public void setData(MyItem[] data) {
        this.data = data;
    }

    // Getter data
    public MyItem[] getData() {
        return data;
    }

    // Method untuk menambahkan item ke array
    public void append(MyItem item, int index) {
        data[index] = item;
    }

    // Method untuk menghitung jumlah data yang terisi
    public int getSize() {

        int count = 0;

        for (MyItem item : data) {

            if (item != null)
                count++;
        }

        return count;
    }

    // Method untuk mencari data berdasarkan key
    public int searching(String key) {

        for (int i = 0; i < data.length; i++) {

            if (data[i] != null &&
                data[i].getData().equals(key)) {

                return i;
            }
        }

        // Jika data tidak ditemukan
        return -1;
    }

    // Method sorting ascending berdasarkan data
    public void sorting() {

        for (int i = 0; i < data.length - 1; i++) {

            for (int j = i + 1; j < data.length; j++) {

                if (data[i] != null &&
                    data[j] != null) {

                    // Membandingkan String
                    if (data[i].getData()
                            .compareTo(data[j].getData()) > 0) {

                        // Proses swap data
                        MyItem temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }
                }
            }
        }
    }
}
