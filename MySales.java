/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdl.remidi;

// Import class dari package ujian
import com.sdl.ujian.MyItem;
import com.sdl.ujian.MyItemList;
import com.sdl.ujian.MyItemMap;

/**
 *
 * @author puspa
 */
public class MySales {

    // Menyimpan daftar penjualan barang
    private MyItemList salesList;

    // Menyimpan daftar harga barang
    private MyItemMap productPrice;

    // Constructor
    public MySales(MyItemList salesList,
                   MyItemMap productPrice){

        this.salesList = salesList;
        this.productPrice = productPrice;
    }

    /*
     * Method untuk menghitung total penjualan
     * total penjualan = jumlah barang x harga barang
     */
    public MyItemMap getTotalSales(){

        // Mengambil data penjualan
        MyItem[] salesData = salesList.getData();

        // Mengambil data harga produk
        MyItem[] priceData = productPrice.getData();

        // Membuat object hasil
        MyItemMap result =
                new MyItemMap(priceData.length);

        // Loop semua produk
        for(int i = 0; i < priceData.length; i++){

            // Jika data kosong maka lanjut
            if(priceData[i] == null){
                continue;
            }

            // Mengambil nama produk
            String product = priceData[i].getData();

            // Variabel total jumlah barang
            int total = 0;

            // Mengecek seluruh data penjualan
            for(int j = 0; j < salesData.length; j++){

                // Jika nama produk sama
                if(salesData[j] != null &&
                   salesData[j].getData()
                           .equals(product)){

                    // Menjumlahkan total barang
                    total += salesData[j]
                             .getNumbers();
                }
            }

            // Mengambil harga produk
            int price =
                    priceData[i].getNumbers();

            // Menghitung total penjualan
            int totalSales = total * price;

            // Menyimpan hasil ke map
            result.append(
                    new MyItem(product, totalSales),
                    i
            );
        }

        // Mengambil data hasil
        MyItem[] resData = result.getData();

        /*
         * Sorting descending
         * dari total penjualan terbesar
         */
        for(int i = 0;
            i < resData.length - 1;
            i++){

            for(int j = 0;
                j < resData.length - i - 1;
                j++){

                if(resData[j] != null &&
                   resData[j + 1] != null &&

                   resData[j].getNumbers()
                   < resData[j + 1].getNumbers()){

                    // Proses swap data
                    MyItem temp = resData[j];
                    resData[j] = resData[j + 1];
                    resData[j + 1] = temp;
                }
            }
        }

        // Mengembalikan hasil total sales
        return result;
    }
}
