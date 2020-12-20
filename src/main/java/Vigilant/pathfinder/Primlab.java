/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;
import Vigilant.pathfinder.Datastructures.Stack;
import Vigilant.pathfinder.Datastructures.Pair;
import Vigilant.pathfinder.Datastructures.List;
/**
 *
 * @author panda
 */
//Primin algoritmill‰ tehty labyrintti

public class Primlab {
private int arr[];    
public int maze[][];
private int size; 
private boolean vis[][];
public int max;
    public Primlab(int size) {
        this.size=size;
        int adjsize=size*2-1; //kasvatamme labyrintin kokoa, jotta saamme sein‰t v‰liin
        int maze[][]=new int[adjsize+1][adjsize+1];
        boolean vis[][]=new boolean[adjsize+1][adjsize+1];
        this.vis=vis;
        this.maze=maze;        
        this.max=max;
    }
    public void createMaze() {
        //0 on sein‰, 1 on solmu, 2 on avoin polku solmujen v‰liss‰ (eli ei sein‰‰), 9 on tilaa jota ei oikeasti ole olemassa (eli ei polkua)
        //otamme aloituspisteeksi labyrintin vasemman yl‰osan (lopuksi t‰m‰ on varmaankin satunnainen piste)
        int totalcells = size*size; //t‰ll‰ muistamme solujen m‰‰r‰n. tarvitsemme t‰t‰ tiet‰‰ksemme, milloin algoritmi on k‰ynyt kaikissa soluissa
        size=size*2-1;
        int hf =0; //muutan t‰m‰n satunnaiseksi soluksi jossain kohtaa
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++) {
                if (i%2==0) {
                    if (j%2==0) {
                        maze[i][j]=1;
                    }
                } else {
                    if (j%2!=0) {
                        maze[i][j]=9;
                    }
                }
            }
        }

        maze[hf][hf]=1;
        List<Pair> walls= new List<Pair>(size);
       // List<Pair> visited = new List<Pair>(size*size);
        Pair p1=new Pair(hf+1, hf);
        walls.add(p1);
        p1=new Pair(hf, hf+1);
        walls.add(p1);
        Pair current=new Pair(hf, hf); 
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                vis[i][j]=false; //taitaa olla t‰ysin turha setup mutta havainnollistaa toimintaa (ehk‰)
            }
        }
        vis[0][0]=true;
        //visited.add(current);
        //alamme rakentamaan labyrintti‰
        int zz = 0;
        while (!walls.isEmpty()) {
            /*
            if (zz>500) {
                System.out.println("walls:" + walls.size);
                break;
            }
            zz++;
            */
            int next=walls.getRand(); //otamme satunnaisen solun merkityist‰
            Pair nx = walls.get(next); 
           // System.out.println("rand; "+next);
            //System.out.println("nxcoords: "+nx.p1 + "," + nx.p2);
            walls.remove(next);
            //boolean foundnew=false;
            if (nx.p1%2==0) { //jos sein‰ on pystysuora
                Pair lc=new Pair(nx.p1,nx.p2-1); //sein‰n vasemmalla oleva solu
                Pair rc = new Pair(nx.p1, nx.p2+1);//sein‰n oikealla oleva solu
                if (vis[lc.p1][lc.p2]==false) { //selvitet‰‰n, onko toinen soluista k‰ym‰tt‰ ja jos on, kumpi
                    maze[nx.p1][nx.p2]=2;
                    current=lc;                 
                    //visited.add(current); //tehd‰‰n tutkitusta solusta nykyinen solu ja lis‰t‰‰n se k‰ytyihin
                    walls=findWalls(walls, current); //lis‰t‰‰n uuden solun sein‰t listaan
                } else if (vis[rc.p1][rc.p2]==false) {
                    maze[nx.p1][nx.p2]=2;
                    current=rc;
                    //visited.add(current);
                    walls=findWalls(walls, current);
                } 
            } else { //sein‰ on vaakasuora
                Pair uc=new Pair(nx.p1-1, nx.p2); //sein‰n yl‰puolella oleva solu
                Pair dc = new Pair(nx.p1+1, nx.p2); //sein‰n alapuolella oleva solu
                if (vis[uc.p1][uc.p2]==false) { //teemme saman kuin pystysuorille seinille
                     maze[nx.p1][nx.p2]=2;
                     current=uc;
                     //visited.add(current);
                     walls=findWalls(walls,current);
                } else if(vis[dc.p1][dc.p2]==false) {
                    maze[nx.p1][nx.p2]=2;
                    current=dc;
                    //visited.add(current);
                    walls=findWalls(walls,current);
                }  
            }
            
            vis[current.p1][current.p2]=true;
          //  System.out.println(current.p1+", "+current.p2);
          //  System.out.println(walls.size);
          
             
        }
    }
    public List findWalls(List<Pair> l, Pair c) { //lis‰‰ walls-listaan solun viereiset sein‰t
        if (c.p1>0) {
            Pair p = new Pair(c.p1-1,c.p2);
            if (!l.contains(p)) {
                l.add(p);
            }          
        }
        if (c.p1<size-1) {
            Pair p = new Pair(c.p1+1, c.p2);
            if (!l.contains(p)) {
                l.add(p);
            } 
        }
        if (c.p2>0) {
            Pair p=new Pair(c.p1, c.p2-1);
            if (!l.contains(p)) {
                l.add(p);
            } 
        }
        if (c.p2<size-1) {
            Pair p = new Pair(c.p1, c.p2+1);
            if (!l.contains(p)) {
                l.add(p);
            } 
        }
        if (l.size>max) {
            max=l.size;
        }
        return l;
    }
    public int[][] getMaze() { //palauttaa labyrintin matriisina
        return maze;
    }
    public void testFt() { // tulostaa labyrintin
        int n = size;
        for (int j=0; j<n;j++) {
            for (int i=0; i<n ;i++) {
                String s=Integer.toString(maze[j][i]);
                System.out.printf(s+" ");
            }
            System.out.println("");
        }
    }
}
