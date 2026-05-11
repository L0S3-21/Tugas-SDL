/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java
 * to edit this template
 */
package com.sdl.test;

// Import class dari package ujian
import com.sdl.ujian.MyItem;
import com.sdl.ujian.MyItemList;
import com.sdl.ujian.MyItemMap;

// Import library JUnit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class MyItemListTest1 {

    // Constructor
    public MyItemListTest1() {
    }

    // Method yang dijalankan sebelum setiap test
    @BeforeEach
    public void setUp() {
    }

    /*
     * Test 1
     * Menguji getSize() dan getDistinctDataSize()
     */
    @Test
    public void test1() {

        // Membuat object MyItem
        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);
        MyItem test2 = new MyItem("C",2);
        MyItem test3 = new MyItem("C",1);

        // Membuat list dengan ukuran 4
        MyItemList listTest = new MyItemList(4);

        // Menambahkan data ke list
        listTest.append(test,0);
        listTest.append(test1,1);
        listTest.append(test2,2);
        listTest.append(test3,3);

        // Menguji jumlah seluruh data
        assertEquals(4, listTest.getSize());

        // Menguji jumlah data unik
        assertEquals(3, listTest.getDistinctDataSize());

        // Membuat list kedua
        MyItemList listTest1 = new MyItemList(3);

        // Menambahkan data
        listTest1.append(test1,0);
        listTest1.append(test2,1);
        listTest1.append(test3,2);

        // Menguji jumlah data
        assertEquals(3, listTest1.getSize());

        // Menguji jumlah data unik
        assertEquals(2, listTest1.getDistinctDataSize());
    }

    /*
     * Test 2
     * Menguji getSumOfNumbersOfData()
     */
    @Test
    public void test2() {

        // Membuat object item
        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);
        MyItem test2 = new MyItem("C",2);
        MyItem test3 = new MyItem("C",1);

        // Membuat list
        MyItemList listTest = new MyItemList(4);

        // Menambahkan data
        listTest.append(test,0);
        listTest.append(test1,1);
        listTest.append(test2,2);
        listTest.append(test3,3);

        // Menguji total numbers untuk data "C"
        assertEquals(3,
                listTest.getSumOfNumbersOfData("C"));

        // Membuat list kedua
        MyItemList listTest1 = new MyItemList(3);

        // Menambahkan data
        listTest1.append(test1,0);
        listTest1.append(test2,1);
        listTest1.append(test3,2);

        // Menguji total numbers
        assertEquals(3,
                listTest1.getSumOfNumbersOfData("C"));
    }

    /*
     * Test 3
     * Menguji getSumOfNumbersOfDistinctData()
     */
    @Test
    public void test3() {

        // Membuat object item
        MyItem test = new MyItem("A",4);
        MyItem test1 = new MyItem("B",3);
        MyItem test2 = new MyItem("C",2);
        MyItem test3 = new MyItem("C",1);

        // Membuat list
        MyItemList listTest = new MyItemList(4);

        // Menambahkan data
        listTest.append(test,0);
        listTest.append(test1,1);
        listTest.append(test2,2);
        listTest.append(test3,3);

        // Mengambil hasil jumlah data unik
        MyItemMap mapTest =
                listTest.getSumOfNumbersOfDistinctData();

        // Sorting data
        mapTest.sorting();

        // Mengambil array data
        MyItem[] dataTest = mapTest.getData();

        // Menguji isi data
        assertEquals(3, dataTest[2].getNumbers());
        assertEquals("C", dataTest[2].getData());

        // Membuat list kedua
        MyItemList listTest1 = new MyItemList(3);

        // Menambahkan data
        listTest1.append(test1,0);
        listTest1.append(test2,1);
        listTest1.append(test3,2);

        // Mengambil hasil jumlah data unik
        MyItemMap mapTest1 =
                listTest1.getSumOfNumbersOfDistinctData();

        // Sorting data
        mapTest1.sorting();

        // Mengambil data
        MyItem[] dataTest1 = mapTest1.getData();

        // Pengujian isi data
        assertEquals(3, dataTest1[1].getNumbers());
        assertEquals("C", dataTest1[1].getData());

        // Menguji ukuran map
        assertEquals(2, mapTest1.getSize());
    }
}
