/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder.pathfinding;
import Vigilant.pathfinder.Datastructures.*;
/**
 *
 * @author panda
 */
public class BFS {
    private int moves;
    private Queue queue;
    private int maze[][];
    private boolean visited[][];
    
    public BFS(int maze[][]) {
        moves=0;      
        int n = maze[0].length;
        queue=new Queue(n*n);
        this.moves=moves;
        this.maze=maze;
        boolean visited[][] = new boolean[n][n];
        this.visited=visited;
    }
     public int search() {
        int n = maze[0].length-1;
        Pair current = new Pair(0,0); //aloitus
        Pair end = new Pair(n-1,n-1);
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                visited[i][j]=false; 
            }
        }
        visited[0][0]=true;
        if (maze[0][1]==2) { //jos pystymme liikkumaan oikealle
            Pair pair1=new Pair(0,2); //huom: solmut joka toisessa alkiossa
            queue.add(pair1);
        }
        if (maze[1][0]==2) { //jos pystymme liikkumaan alas
            Pair pair2= new Pair(2,0);
            queue.add(pair2);
        }
        List<Pair> lp = new List<Pair>(500); //debuggaamista varten
        //-------------------------------------------------------- while loop
        int v = 0;
        while (!queue.isEmpty()) {          
            Pair p=queue.getPair(); //parien poppaamista helpottava funktio
            current=p;
            //lp.add(current);
            moves++;
            if (current.equals(end)) {
                v++;
                System.out.println("BFS found path in " + moves + " moves. It did its best.");
                break;
            }
            getPaths(current);  //etsimme solmun yhteydet 
            visited[current.p1][current.p2]=true;       
        }
        if (v==0) {
            System.out.println("No path found! Uh oh!");
        }
        /* debuggausta varten
        for (int i =0;i<lp.size;i++) {
            System.out.println(lp.get(i).p1+", "+lp.get(i).p2);
        }
*/
        return moves;
    }
    public void getPaths(Pair p) { 
        if (p.p1>0) {
            if (maze[p.p1-1][p.p2]==2 && visited[p.p1-2][p.p2]==false) { // jos solmun yläpuolelle voi liikkua ja siinä ei olla käyty
                Pair q=new Pair(p.p1-2, p.p2);
                queue.add(q);              
            }
        }
        if (p.p2>0) {
            if (maze[p.p1][p.p2-1]==2 && visited[p.p1][p.p2-2]==false) { //sama idea, mutta vasemmalle
                Pair q = new Pair(p.p1, p.p2-2); 
                queue.add(q);
            }
        }     
        if (p.p1<maze[0].length-1) {
            if (maze[p.p1+1][p.p2]==2 && visited[p.p1+2][p.p2]==false) { //alas
                Pair q = new Pair(p.p1+2, p.p2); 
                queue.add(q);
            }
        }
        if (p.p2<maze[0].length-1) {
            if (maze[p.p1][p.p2+1]==2 && visited[p.p1][p.p2+2]==false) { //oikealle
                Pair q = new Pair(p.p1, p.p2+2); 
                queue.add(q);
            }
        }
    }
    public void testFt() { 
        int n = maze[0].length-1;
        for (int j=0; j<n;j++) {
            for (int i=0; i<n ;i++) {
                String s=Integer.toString(maze[j][i]);
                System.out.printf(s+" ");
            }
            System.out.println("");
        }
    }
}
