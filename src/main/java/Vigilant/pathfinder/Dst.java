/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;

/**
 *
 * @author panda
 */

public class Dst {
private int arr[];    
    public Dst() {
        int arr[]=new int[10];
        this.arr=arr;
        arr[0]=5;
        arr[1]=2;
        
    }
    public String toString() {
        //for (int i=0;i<arr[].length; i++){
        //    System.out.println(arr[i]);
        //}
        int c = arr[0];
        System.out.println(c);
        arr[0]=7;
        int b=arr[0];
        System.out.println(b);
        String s=Integer.toString(b);
        return ("aaa "+b);
    }
}
