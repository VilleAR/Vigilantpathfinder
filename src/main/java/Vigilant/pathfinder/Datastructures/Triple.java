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
//A-staria varten
//javan oman implementaation addin aikavaativuus O(n*log n) 

public class Triple {
    public int p1, p2, p3;
    
    public Triple(int p1, int p2, int p3) {
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        
    }
    public boolean equals (Triple t) {
        if (t.p1==p1 && t.p2==p2) {
            return true;
        } else {
            return false;
        }
    }
    
}
