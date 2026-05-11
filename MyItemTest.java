package com.sdl.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Import library JUnit
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Import class MyItem
import com.sdl.ujian.*;

/**
 *
 * @author puspa
 */
public class MyItemTest {

    // Constructor
    public MyItemTest() {
    }

    // Method yang dijalankan sebelum setiap test
    @BeforeEach
    public void setUp() {
    }

    /*
     * Test 1
     * Menguji constructor, setter, dan getter
     */
    @Test
    public void test1(){

        // Membuat object MyItem dengan constructor kosong
        MyItem test = new MyItem();

        // Mengisi data menggunakan setter
        test.setData("A");
        test.setNumbers(4);

        // Pengujian getter
        assertEquals("A", test.getData());
        assertEquals(4, test.getNumbers());

        // Membuat object menggunakan constructor parameter
        MyItem test1 = new MyItem("B",3);

        // Pengujian getter
        assertEquals("B", test1.getData());
        assertEquals(3, test1.getNumbers());
    }

    /*
     * Test 2
     * Menguji method toString()
     */
    @Test
    public void test2(){

        // Membuat object MyItem
        MyItem test = new MyItem();

        // Mengisi data
        test.setData("A");
        test.setNumbers(4);

        // Pengujian hasil String object
        assertEquals("A = 4", test.toString());

        // Membuat object kedua
        MyItem test1 = new MyItem("B",3);

        // Pengujian hasil String object
        assertEquals("B = 3", test1.toString());
    }
}
