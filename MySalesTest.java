/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdl.remidi;

import com.sdl.ujian.*;
import com.sdl.remidi.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author puspa
 */
public class MySalesTest {
    
    public MySalesTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @Test
    public void test1(){
        MyItem test1 = new MyItem("A",4);
        MyItem test2 = new MyItem("B",3);
        MyItem test3 = new MyItem("C",2);
        MyItem test4 = new MyItem("A",4);
        
        MyItem test10 = new MyItem("A",5);
        MyItem test20 = new MyItem("B",50);
        MyItem test30 = new MyItem("C",100);
        
        MyItemMap mapTest = new MyItemMap(3);
        mapTest.append(test10,0);
        mapTest.append(test20,1);
        mapTest.append(test30,2);
        
        MyItemList listTest = new MyItemList(4);
        listTest.append(test1,0);
        listTest.append(test2,1);
        listTest.append(test3,2);
        listTest.append(test4,3);
        
        MySales salesTest = new MySales(listTest,mapTest);
        MyItemMap salesResult = salesTest.getTotalSales();
        MyItem[] data = salesResult.getData();
        assertEquals("C",data[0].getData());
        assertEquals("B",data[1].getData());
        assertEquals("A",data[2].getData());
        assertEquals(200,data[0].getNumbers());
    }
    
}
