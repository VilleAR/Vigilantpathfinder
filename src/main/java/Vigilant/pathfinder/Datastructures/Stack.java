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
public class Stack<T> {
    //teemme itse stackin koodausta varten
    //stack on palautuksessa 5 muutettu objektityyppiseksi
    private Object arr[];
    private int top;
    
    public Stack(int s) {
        arr=new Object[s];
        this.arr=arr;
        this.top=top;
    }
    public void push(T t) {  
        arr[++top] = t;
    }
    public T pop() {
        return (T) arr[top--];
    }
    public Pair spop() {
        if(top==0) {
            System.out.println("stack empty");
        }
        return (Pair) arr[top--];
    }
    public T peek() {
        return (T) arr[top];
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
