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
public class Random {
    
    public long getRand(int x) {
        long t=System.currentTimeMillis();
        
        if (x<10) {
            long b = t%10;
            if (b<x) {
                return (int) b;
            } else {
                return 10-b;
            }
        }
        return t;
    }
}
