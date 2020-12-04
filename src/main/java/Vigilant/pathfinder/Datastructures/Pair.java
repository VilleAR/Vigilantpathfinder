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
//teemme int-muotoisen Pair-luokan
public class Pair {
public int p1, p2;
    public Pair(int p1, int p2) {
        this.p1=p1;
        this.p2=p2;
    }
    public boolean equals(Pair p) {
        if (p1==p.p1&&p2==p.p2) {
            return(true);
        } else {
            return(false);
        }
    }
    public int one() {
        return p1;
    }
    public int two() {
        return p2;
    }
}
