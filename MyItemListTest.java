/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdl.test;

// Import class dari package ujian
import com.sdl.ujian.*;

// Import library JUnit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author puspa
 */
public class MyItemListTest {

    // Constructor
    public MyItemListTest() {
    }

    // Method yang dijalankan sebelum setiap test
    @BeforeEach
    public void setUp() {
    }

    /*
     * Test 1
     * Menguji method setData() dan getData()
     */
    @Test
    public void test1(){

        // Membuat object MyItem
        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);

        // Membuat array MyItem
        MyItem[] testList = new MyItem[2];

        // Mengisi array
        testList[0] = test;
        testList[1] = test1;

        // Membuat object MyItemList
        MyItemList listTest = new MyItemList();

        // Mengisi data ke list
        listTest.setData(testList);

        // Mengambil data dari list
        MyItem[] dataTest = listTest.getData();

        // Pengujian hasil data
        assertEquals("A = 4", dataTest[0].toString());
    }

    /*
     * Test 2
     * Menguji method searching()
     */
    @Test
    public void test2(){

        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);
        MyItem test2 = new MyItem("C",2);

        // Membuat array
        MyItem[] testList = new MyItem[3];

        // Data belum urut
        testList[2] = test;
        testList[1] = test1;
        testList[0] = test2;

        // Membuat object list
        MyItemList listTest = new MyItemList();

        // Memasukkan data
        listTest.setData(testList);

        // Pengujian searching
        assertEquals(0, listTest.searching("C"));

        // Jika data tidak ditemukan
        assertEquals(-1, listTest.searching("D"));
    }

    /*
     * Test 3
     * Menguji method sorting()
     */
    @Test
    public void test3(){

        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);
        MyItem test2 = new MyItem("C",2);

        // Membuat array
        MyItem[] testList = new MyItem[3];

        // Data belum urut
        testList[2] = test;
        testList[1] = test1;
        testList[0] = test2;

        // Membuat object list
        MyItemList listTest = new MyItemList();

        // Memasukkan data
        listTest.setData(testList);

        // Sorting data
        listTest.sorting();

        // Setelah sorting:
        // A index 0
        // C index 2
        assertEquals(2, listTest.searching("C"));
        assertEquals(0, listTest.searching("A"));
    }

    /*
     * Test 4
     * Menguji method append()
     */
    @Test
    public void test4(){

        // Membuat object item
        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);
        MyItem test2 = new MyItem("C",2);
        MyItem test3 = new MyItem("C",1);

        // Membuat object list dengan ukuran 4
        MyItemList listTest = new MyItemList(4);

        // Menambahkan data ke list
        listTest.append(test,0);
        listTest.append(test1,1);
        listTest.append(test2,2);
        listTest.append(test3,3);

        // Mengambil data dari list
        MyItem[] dataTest = listTest.getData();

        // Pengujian isi data
        assertEquals(1, dataTest[3].getNumbers());
        assertEquals("C", dataTest[3].getData());
    }
}
