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
//hyv‰t ideat tulevat tarpeeseen

public class Random {
    //hyv‰ idea:
    public int getRand(int x) {
        long t = System.nanoTime()/100;
        long q = t%x;
        int a = (int)q; 
        return a; //voisi ehk‰ vain returnata (int) q aiemmalla rivill‰ mutta pelaan varman p‰‰lle
    }
}
