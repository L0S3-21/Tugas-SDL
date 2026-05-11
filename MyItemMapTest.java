/*
 * File : MyItemMapTest.java
 * Fungsi : Unit Testing untuk class MyItemMap
 */
package com.sdl.test;

// Import semua class dari package ujian
import com.sdl.ujian.*;

// Import library JUnit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author puspa
 */
public class MyItemMapTest {

    // Constructor
    public MyItemMapTest() {
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
    public void test1() {

        // Membuat object MyItem
        MyItem itemA = new MyItem("A", 4);
        MyItem itemB = new MyItem("B", 3);

        // Membuat array MyItem
        MyItem[] itemList = new MyItem[2];

        // Memasukkan object ke array
        itemList[0] = itemA;
        itemList[1] = itemB;

        // Membuat object MyItemMap
        MyItemMap mapTest = new MyItemMap(2);

        // Mengisi data ke map
        mapTest.setData(itemList);

        // Mengambil data dari map
        MyItem[] dataTest = mapTest.getData();

        // Pengujian isi data
        assertEquals("A", dataTest[0].getData());
        assertEquals(4, dataTest[0].getNumbers());
    }

    /*
     * Test 2
     * Menguji method searching()
     */
    @Test
    public void test2() {

        // Membuat object item
        MyItem itemA = new MyItem("A", 4);
        MyItem itemB = new MyItem("B", 3);
        MyItem itemC = new MyItem("C", 2);

        // Membuat array
        MyItem[] itemList = new MyItem[3];

        // Mengisi array
        itemList[0] = itemC;
        itemList[1] = itemB;
        itemList[2] = itemA;

        // Membuat object map
        MyItemMap mapTest = new MyItemMap(3);

        // Set data ke map
        mapTest.setData(itemList);

        // Menguji pencarian data
        assertEquals(0, mapTest.searching("C"));

        // Jika data tidak ditemukan maka return -1
        assertEquals(-1, mapTest.searching("D"));
    }

    /*
     * Test 3
     * Menguji method sorting()
     */
    @Test
    public void test3() {

        // Membuat object item
        MyItem itemA = new MyItem("A", 4);
        MyItem itemB = new MyItem("B", 3);
        MyItem itemC = new MyItem("C", 2);

        // Membuat array
        MyItem[] itemList = new MyItem[3];

        // Data belum urut
        itemList[0] = itemC;
        itemList[1] = itemB;
        itemList[2] = itemA;

        // Membuat object map
        MyItemMap mapTest = new MyItemMap(3);

        // Memasukkan data
        mapTest.setData(itemList);

        // Melakukan sorting ascending
        mapTest.sorting();

        // Setelah sorting:
        // A index 0
        // B index 1
        // C index 2
        assertEquals(0, mapTest.searching("A"));
        assertEquals(2, mapTest.searching("C"));
    }

    /*
     * Test 4
     * Menguji method append()
     */
    @Test
    public void test4() {

        // Membuat item
        MyItem itemA = new MyItem("A", 4);
        MyItem itemB = new MyItem("B", 3);
        MyItem itemC = new MyItem("C", 2);

        // Membuat object map
        MyItemMap mapTest = new MyItemMap(3);

        // Menambahkan data ke map
        mapTest.append(itemA, 0);
        mapTest.append(itemB, 1);
        mapTest.append(itemC, 2);

        // Mengambil data dari map
        MyItem[] dataTest = mapTest.getData();

        // Pengujian isi data
        assertEquals("C", dataTest[2].getData());
        assertEquals(2, dataTest[2].getNumbers());
    }

    /*
     * Test 5
     * Menguji method getSize()
     */
    @Test
    public void test5() {

        // Membuat item
        MyItem itemA = new MyItem("A", 4);
        MyItem itemB = new MyItem("B", 3);
        MyItem itemC = new MyItem("C", 2);

        // Membuat object map pertama
        MyItemMap mapTest = new MyItemMap(3);

        // Menambahkan data
        mapTest.append(itemA, 0);
        mapTest.append(itemB, 1);
        mapTest.append(itemC, 2);

        // Menguji jumlah data
        assertEquals(3, mapTest.getSize());

        // Membuat object map kedua
        MyItemMap mapTest1 = new MyItemMap(2);

        // Menambahkan data
        mapTest1.append(itemA, 0);
        mapTest1.append(itemB, 1);

        // Menguji jumlah data
        assertEquals(2, mapTest1.getSize());

        // Mengambil data
        MyItem[] dataTest = mapTest1.getData();

        // Pengujian isi data
        assertEquals("B", dataTest[1].getData());
        assertEquals(3, dataTest[1].getNumbers());
    }
}
