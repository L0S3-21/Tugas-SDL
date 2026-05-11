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
public class MyItemList {

    // Array untuk menyimpan object MyItem
    private MyItem[] data;

    // Constructor kosong
    public MyItemList() {}

    // Constructor dengan parameter size
    public MyItemList(int size) {
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

    // Method untuk menambahkan item ke index tertentu
    public void append(MyItem item, int index) {

        // Jika index masih kosong
        if (data[index] == null) {
            data[index] = item;

        } else {

            // Jika data berbeda maka diganti
            if (!data[index].getData().equals(item.getData())) {
                data[index] = item;
            }
        }
    }

    // Method untuk menghitung jumlah data yang tidak null
    public int getSize() {

        int count = 0;

        for (MyItem item : data) {
            if (item != null) count++;
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

        // Jika tidak ditemukan
        return -1;
    }

    // Method sorting ascending berdasarkan data
    public void sorting() {

        for (int i = 0; i < data.length - 1; i++) {

            for (int j = i + 1; j < data.length; j++) {

                if (data[i] != null && data[j] != null) {

                    if (data[i].getData()
                            .compareTo(data[j].getData()) > 0) {

                        // Proses pertukaran data
                        MyItem temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }
                }
            }
        }
    }

    // Method untuk menghitung jumlah data unik
    public int getDistinctDataSize() {

        int count = 0;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == null) continue;

            boolean duplicate = false;

            // Mengecek apakah data sudah pernah muncul
            for (int j = 0; j < i; j++) {

                if (data[j] != null &&
                    data[j].getData().equals(data[i].getData())) {

                    duplicate = true;
                    break;
                }
            }

            // Jika bukan duplikat maka count bertambah
            if (!duplicate) count++;
        }

        return count;
    }

    // Method untuk menjumlahkan numbers berdasarkan key tertentu
    public int getSumOfNumbersOfData(String key) {

        int sum = 0;

        for (MyItem item : data) {

            if (item != null &&
                item.getData().equals(key)) {

                sum += item.getNumbers();
            }
        }

        return sum;
    }

    // Method untuk membuat map berisi data unik dan total jumlahnya
    public MyItemMap getSumOfNumbersOfDistinctData() {

        MyItemMap map = new MyItemMap(data.length);

        for (int i = 0; i < data.length; i++) {

            if (data[i] == null) continue;

            String key = data[i].getData();

            // Jika key belum ada di map
            if (map.searching(key) == -1) {

                int sum = getSumOfNumbersOfData(key);

                map.append(
                    new MyItem(key, sum),
                    map.getSize()
                );
            }
        }

        return map;
    }
}
