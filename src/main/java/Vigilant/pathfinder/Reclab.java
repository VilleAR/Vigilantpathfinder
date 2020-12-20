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
public class Reclab {
    public int remaze[][];
    private int size;
    private boolean visited[][];
    
    public Reclab (int size) {
        this.size=size;
        int adjsize=size*2;
        int remaze[][]=new int[adjsize][adjsize];
        this.remaze=remaze;
        this.visited=visited;
    }
    public void createMaze() {
    int totalcells = size*size; 
        size=size*2-1;
        int hf =0; 
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++) {
                if (i%2==0) {
                    if (j%2==0) {
                        remaze[i][j]=1;
                    }
                } else {
                    if (j%2!=0) {
                        remaze[i][j]=9;
                    }
                }
                if(remaze[i][j]==0) {
                    remaze[i][j]=2;
                }
            }
        }
        
    }
    public int[][]getMaze() {
        return remaze;
    }
    
    
    
    
}
