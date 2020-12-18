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
public class Tstack<T> {
    private Triple arr[];
    private int top;
    public Tstack(int s) {
        arr=new Triple[s];
        this.top=top;
        this.arr=arr;
    }
    public void push(Triple t) {
        int dist = t.p3;
        int size = top;
        if (size==0) {
            arr[++top] = t;
        } else if (dist<arr[top].p3) {
            arr[++top]=t;
        } else if (dist>arr[1].p3) {
            for (int i=top;i>0;i--) {
                arr[i+1]=arr[i];
            }
            arr[1]=t;
            top++;
        } else {           
            while (size>0) {
                if (dist>arr[size].p3) {
                    size--;
                } else {
                    int spot = size;
                    int inc = top;
                    while (inc>size) {
                        arr[inc+1]=arr[inc];
                        inc--;
                    }
                    arr[spot+1]=t;
                    size=-1;
                    
                }
            }
            top++;
        }
        
    }
    public Triple pop() {
        if(top==0) {
            System.out.println("Stack is empty");
            Triple failed=new Triple(0,0,0);
            return failed;
        }
        return (Triple) arr[top--];
    }
    public Triple peek() {
        return (Triple) arr[top];
    }
    public int size() {
        return top;
    }
}
