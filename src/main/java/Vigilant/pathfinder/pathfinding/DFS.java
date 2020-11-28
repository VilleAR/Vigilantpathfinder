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
//depth first search
//etsii JONKUN polun
//nopeimman polun etsiminen olisi sama kuin exhaustive search
public class DFS {
    private int moves; //laskee polun etsimiseen menneet siirtym‰t, v‰hemm‰n on parempi
    private Stack stack; //sis‰lt‰‰ jonossa olevat solmut
    private int maze[][];
    private boolean visited[][];
    private int size;
    
    public DFS(int[][] maze) {
        moves=0;
        stack = new Stack(10000000); //mahdolliset vierailtavat solmut
        this.maze=maze;
        int n = maze[0].length-1;
        boolean visited[][] = new boolean[n+1][n+1]; //k‰yt‰mme boolean matriisia pit‰m‰‰n kirjaa k‰ydyist‰ solmuista, paljon nopeampi kuin aiempi ratkaisu (aiempi ratkaisu oli hyvin huono)
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
            lp.add(current);
            moves++;
            if (current.equals(end)) {
                System.out.println("Found path in " + moves + " moves. Not bad! (Unless this number is very high)");
                break;
            }
            getPaths(current);  //etsimme solmun yhteydet 
            visited[current.p1][current.p2]=true;
                  
        }
        /*
        while (stack.size()>0) {
            Pair p = stack.spop();
            System.out.println(p.p1+", "+p.p2);
        }
*/      /*
        System.out.println("moves made: (start at 0,0) ");
        for (int i=0;i<lp.size;i++) {
            System.out.println(lp.get(i).p1 + ", "+ lp.get(i).p2);
        }
*/
        return moves-1;
    }
    public void getPaths(Pair p) { // k‰yt‰nnˆss‰ sama idea kuin primlabin walls-funktio, eli lis‰‰ stackiin solmusta mahdolliset polut
        //if-lauseiden j‰rjestys on mietitty toimintaa varten, etsint‰prioriteetit siis oikealle>alas>ylˆs>vasemmalle
        if (p.p1>0) { //v‰ltt‰‰ nullpointerexceptionit
            if (maze[p.p1-1][p.p2]==2 && visited[p.p1-2][p.p2]==false) { // jos solmun yl‰puolelle voi liikkua ja siin‰ ei olla k‰yty
                Pair q=new Pair(p.p1-2, p.p2);
                stack.push(q);              
            }
        }
        if (p.p2>0) {
            if (maze[p.p1][p.p2-1]==2 && visited[p.p1][p.p2-2]==false) { //sama idea, mutta vasemmalle
                Pair q = new Pair(p.p1, p.p2-2); 
                stack.push(q);
            }
        }     
        if (p.p1<maze[0].length-1) {
            if (maze[p.p1+1][p.p2]==2 && visited[p.p1+2][p.p2]==false) { //alas
                Pair q = new Pair(p.p1+2, p.p2); 
                stack.push(q);
            }
        }
        if (p.p2<maze[0].length-1) {
            if (maze[p.p1][p.p2+1]==2 && visited[p.p1][p.p2+2]==false) { //oikealle
                Pair q = new Pair(p.p1, p.p2+2); 
                stack.push(q);
            }
        }
    }
    
    public void testFt() { // tulostaa labyrintin, aika turha koska primlabill‰ sama
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
