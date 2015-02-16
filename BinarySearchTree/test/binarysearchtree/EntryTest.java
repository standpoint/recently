/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author volodya
 */
public class EntryTest {
    
    public EntryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getKey method, of class Entry.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        Entry instance = null;
        Object expResult = null;
        Object result = instance.getKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKey method, of class Entry.
     */
    @Test
    public<K extends Comparable<K>> void testSetKey() {
        System.out.println("setKey");
        K key = null;
        Entry instance = null;
        instance.setKey(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Entry.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Entry instance = null;
        Object expResult = null;
        Object result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Entry.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Object value = null;
        Entry instance = null;
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Entry.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Entry e = null;
        Entry instance = null;
        int expResult = 0;
        int result = instance.compareTo(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
