/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder.Datastructures;

/**
 *
 * @author panda
 */
//hyvät ideat tulevat tarpeeseen

public class Random {
    
    public int getRand(int x) {
        long t = System.nanoTime()/100;
        long q = t%x;
        int a = (int)q;
        return a;
    }
}
