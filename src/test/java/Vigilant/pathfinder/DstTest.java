/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;
import Vigilant.pathfinder.Datastructures.Stack;
import Vigilant.pathfinder.Datastructures.Pair;
import Vigilant.pathfinder.Datastructures.List;
/**
 *
 */
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DstTest {
    Dst dst;
    Dst dst2;
    Stack stack;
   // Primlab prim;
    @Before 
    public void setUp() {
        dst=new Dst(2);
        dst2=new Dst(3);
        stack=new Stack(10);
       // prim=new Primlab(7); ei kannata
    }
    @Test
    public void minSize() { //testaa, hyväksyykö Dst koon oikein
        String tavoite = "Too small!!!";
        assertEquals(tavoite, dst.testMap());
        String tavoite2="t";
        assertEquals(tavoite2, dst2.testMap());
    }
    /* vanhentunut
    @Test
    public void mazeSetUp() { //tämä tarkistaa sekä itse labyrintin alustamisen täyteen nollia että lähtöpisteen
        prim.createMaze();
        assertEquals(1, prim.maze[3][3]);
    }
    */
    @Test 
    public void listTest() { //testaa listaa
        List<Integer> l1=new List<Integer>(2);
        l1.add(2);
        l1.add(7);
        int g = l1.get(1);
        assertEquals(7, g); 
        l1.add(99);
        g=l1.get(2); //testaamme listan automaattista kasvamista taulukon koon ylittyessä
        assertEquals(99, g);
    }
    
    @Test 
    public void listRemoveTest() {
        List<Pair>lp = new List<Pair>(5);
        Pair pair=new Pair (5,10);
        Pair pair2 = new Pair(1,2);
        lp.add(pair);
        lp.add(pair2);
        lp.remove(0);
        assertEquals(2, lp.get(0).p2); //testaa remove-funktion toimintaa objektilla
    }

    @Test
    public void pairTest() {
        Pair pair=new Pair(3,5); //Pair tukee vain integerejä
        assertEquals(5, pair.p2);
        Pair pair2 = new Pair(3,6);
        pair2.p2--;
        boolean t = true;
        assertEquals(t, pair.equals(pair2));
    }
    @Test
    public void stackTest() {
        Stack stak = new Stack(5);
        stak.push(3);
        stak.push(2);
        stak.pop();
        assertEquals(3, stak.pop());
        stak.push(1);
        stak.push(99);
        assertEquals(99, stak.peek());
        assertEquals(2, stak.size());
    }
    @Test
    public void combinationTest() {//testaamme listaa objekteilla, stack ja pair eivät vielä tue objekteja
        List<Pair>lp = new List<Pair>(5);
        Pair pair=new Pair (5,10);
        Pair pair2 = new Pair(1,2);
        lp.add(pair);
        lp.add(pair2);
        assertEquals(10, lp.get(0).p2);
        Pair pair3= new Pair(5,10);
        assertEquals(true, lp.contains(pair3));
        List<Stack>ls = new List<Stack>(5);
        stack.push(1);
        Stack stak= new Stack(5);
        stak.push(1);
        ls.add(stack);
        ls.add(stak);
        assertEquals(1, ls.get(1).pop());
    }   
}
