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
        this.front=front;
        this.rear=rear;
    }
    public void add(T t) {
        arr[rear++]=t;
        
    }
    public Object getNext() {
        Object t = arr[front];
        
        for (int i=0;i<rear;i++) {
            arr[i]=arr[i+1];
        }
        arr[rear]=0;
        rear--;
        return t;      
    }
    public Pair getPair() {
        Pair p = (Pair) arr[front];
        for (int i=0;i<rear;i++) {
            arr[i]=arr[i+1];
        }
        arr[rear]=0;
        rear--;
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
