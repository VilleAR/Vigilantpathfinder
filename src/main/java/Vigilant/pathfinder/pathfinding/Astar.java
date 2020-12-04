/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder.pathfinding;
import Vigilant.pathfinder.Primlab;
import Vigilant.pathfinder.Datastructures.Stack;
import Vigilant.pathfinder.Datastructures.List;
import Vigilant.pathfinder.Datastructures.Pair;
/**
 *
 * @author panda
 */
//A-star 
//sama kuin DFS, mutta fiksumpi
//vielä työn alla, implementoin priority queue-rakenteen ensin

/*
public class Astar {
    private int moves; //laskee polun etsimiseen menneet siirtymät, vähemmän on parempi
    private Stack stack; //sisältää jonossa olevat solmut
    private int maze[][];
    private boolean visited[][];
    private int size;
    
    public Astar(int[][] maze) {
        moves=0;
        stack = new Stack(10000000); //mahdolliset vierailtavat solmut
        this.maze=maze;
        int n = maze[0].length-1;
        boolean visited[][] = new boolean[n+1][n+1]; //käytämme boolean matriisia pitämään kirjaa käydyistä solmuista,
        this.visited=visited;
    }
    public int search() {
        int n = maze[0].length-1;
        Pair current = new Pair(0,0); //aloitus
        Pair end = new Pair(n-1,n-1);
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                visited[i][j]=false; //taitaa olla täysin turha setup mutta havainnollistaa toimintaa (ehkä)
            }
        }
        visited[0][0]=true;
        if (maze[0][1]==2) { //jos pystymme liikkumaan oikealle
            Pair pair1=new Pair(0,2); //huom: solmut joka toisessa alkiossa
            stack.push(pair1);
        }
        if (maze[1][0]==2) { //jos pystymme liikkumaan alas
            Pair pair2= new Pair(2,0);
            stack.push(pair2);
        }
        List<Pair> lp = new List<Pair>(500); //debuggaamista varten
        //-------------------------------------------------------- while loop
        while (stack.size()>0) {          
            Pair p=stack.spop(); //parien poppaamista helpottava funktio
            current=p;
            //lp.add(current);
            moves++;
            if (current.equals(end)) {
                System.out.println("A* found path in " + moves + " moves. Hopefully faster than the others or something is wrong!");
                break;
            }
            getPaths(current);  //etsimme solmun yhteydet 
            visited[current.p1][current.p2]=true;                
        }
*/


