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
public class Queue<T> {
    private Object arr[];
    private int front, rear;
    public Queue(int s) {       
        arr=new Object[s];
        this.arr=arr;
        this.front=s-1;
        this.rear=s-1;
    }
    public void add(T t) {
        arr[rear--]=t;
        
    }
    public Object getNext() {
        Object t = arr[front--];

        return t;      
    }
    public Pair getPair() {
        Pair p = (Pair) arr[front--];

        return p;
    }
    public boolean isEmpty() {
        if (front==rear) {
            return true;
        } else {
            return false;
        }
    }
}
