/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder.pathfinding;
import Vigilant.pathfinder.Primlab;
import Vigilant.pathfinder.Datastructures.*;
/*
 *
 * @author panda
 */
//A-star 
//sama kuin DFS, mutta fiksumpi



public class Astar {
    private int moves; //laskee polun etsimiseen menneet siirtym‰t, v‰hemm‰n on parempi
    private Tstack stack; //sis‰lt‰‰ jonossa olevat solmut
    private int maze[][];
    private boolean visited[][];
    private int size;
    
    public Astar(int[][] maze) {
        moves=0;
        stack = new Tstack(10000000); //mahdolliset vierailtavat solmut
        this.maze=maze;
        int n = maze[0].length-1;
        boolean visited[][] = new boolean[n+1][n+1]; //k‰yt‰mme boolean matriisia pit‰m‰‰n kirjaa k‰ydyist‰ solmuista,
        this.visited=visited;
    }
    public int search() {
        int n = maze[0].length-1;
        Pair current = new Pair(0,0); //aloitus
        Pair end = new Pair(n-1,n-1);
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                visited[i][j]=false; //taitaa olla t‰ysin turha setup mutta havainnollistaa toimintaa (ehk‰)
            }
        }
        visited[0][0]=true;
        if (maze[0][1]==2) { //jos pystymme liikkumaan oikealle
            Triple trip1=new Triple(0,2,2); //huom: solmut joka toisessa alkiossa
            stack.push(trip1);
        }
        if (maze[1][0]==2) { //jos pystymme liikkumaan alas
            Triple trip2 = new Triple(2,0,2);
            stack.push(trip2);
        }
        List<Pair> lp = new List<Pair>(500); //debuggaamista varten
        //-------------------------------------------------------- while loop
        while (stack.size()>0) {          
            Triple t=stack.pop(); //parien poppaamista helpottava funktio
            Pair p = new Pair(t.p1, t.p2);
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
        return moves;
    }
        public void getPaths(Pair p) { // k‰yt‰nnˆss‰ sama idea kuin primlabin walls-funktio, eli lis‰‰ stackiin solmusta mahdolliset polut
        //if-lauseiden j‰rjestys on mietitty toimintaa varten, etsint‰prioriteetit siis oikealle>alas>ylˆs>vasemmalle
        if (p.p1>0) { //v‰ltt‰‰ nullpointerexceptionit
            if (maze[p.p1-1][p.p2]==2 && visited[p.p1-2][p.p2]==false) { // jos solmun yl‰puolelle voi liikkua ja siin‰ ei olla k‰yty
                Pair q=new Pair(p.p1-2, p.p2);
                int p3=getDist(q);
                Triple r=new Triple(q.p1, q.p2, p3);
                stack.push(r);              
            }
        }
        if (p.p2>0) {
            if (maze[p.p1][p.p2-1]==2 && visited[p.p1][p.p2-2]==false) { //sama idea, mutta vasemmalle
                Pair q = new Pair(p.p1, p.p2-2); 
                int p3=getDist(q);
                Triple r=new Triple(q.p1, q.p2, p3);
                stack.push(r);   
            }
        }     
        if (p.p1<maze[0].length-1) {
            if (maze[p.p1+1][p.p2]==2 && visited[p.p1+2][p.p2]==false) { //alas
                Pair q = new Pair(p.p1+2, p.p2); 
                int p3=getDist(q);
                Triple r=new Triple(q.p1, q.p2, p3);
                stack.push(r);   
            }
        }
        if (p.p2<maze[0].length-1) {
            if (maze[p.p1][p.p2+1]==2 && visited[p.p1][p.p2+2]==false) { //oikealle
                Pair q = new Pair(p.p1, p.p2+2); 
                int p3=getDist(q);
                Triple r=new Triple(q.p1, q.p2, p3);
                stack.push(r);   
            }
        }
    }
    public int getDist(Pair p) {
        Pair e = new Pair(maze[0].length-1, maze[0].length-1);
        int d1=(e.p1-p.p1)*(e.p1-p.p1);
        int d2=(e.p2-p.p2)*(e.p2-p.p2);
        return d1+d2;
    }
    
}


