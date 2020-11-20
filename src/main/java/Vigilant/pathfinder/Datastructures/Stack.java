/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder.Datastructures;
import java.util.Random; //tilapäinen ratkaisu
/**
 *
 * @author panda
 */
public class Stack {
    //teemme itse stackin koodausta varten
    private int arr[];
    private int top;
    public Stack(int s) {
        arr=new int [s];
        this.arr=arr;
        this.top=top;
    }
    public void push(int j) {
        arr[++top] = j;
    }
    public int pop() {
        return arr[top--];
    }
    public int peek() {
        return arr[top];
    }
    public boolean isEmpty() { //melko turha
        return (top == -1);
    }
    public int size() {
        return top;
    }
    public int rand() {
        Random r = new Random();
        return r.nextInt(top-1);
    }
}   
