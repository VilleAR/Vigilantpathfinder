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
    public Primlab(int size) {
        this.size=size;
        int adjsize=size*2-1; //kasvatamme labyrintin kokoa, jotta saamme sein‰t v‰liin
        int maze[][]=new int[adjsize+1][adjsize+1];
        this.maze=maze;
        
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
        //n‰ill‰ taulukoilla pid‰mme kirjaa hf:n naapureista
        /*
        int hr=hf;
        int hc=hf;
        Stack str=new Stack(size); //naapurin rivinumero
        Stack stc=new Stack(size); //naapurin kolumninumero
        str.push(hr);
        stc.push(hc-1);
        str.push(hr-1);
        stc.push(hc);
        str.push(hr+1);
        stc.push(hc);
        str.push(hr);
        stc.push(hc+1);
        
        while (!stc.isEmpty()) {
            int a=str.pop();
            int b = stc.pop();
            maze[a][b]=1;
        }
        */
        maze[hf][hf]=1;
        List<Pair> walls= new List<Pair>(size);
        List<Pair> visited = new List<Pair>(size*size);
        Pair p1=new Pair(hf+1, hf);
        walls.add(p1);
        p1=new Pair(hf, hf+1);
        walls.add(p1);
        Pair current=new Pair(hf, hf); 
        visited.add(current);
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
                if (!visited.contains(lc)) { //selvitet‰‰n, onko toinen soluista k‰ym‰tt‰ ja jos on, kumpi
                    maze[nx.p1][nx.p2]=2;
                    current=lc;
                    visited.add(current); //tehd‰‰n tutkitusta solusta nykyinen solu ja lis‰t‰‰n se k‰ytyihin
                    walls=findWalls(walls, current); //lis‰t‰‰n uuden solun sein‰t listaan
                } else if (!visited.contains(rc)) {
                    maze[nx.p1][nx.p2]=2;
                    current=rc;
                    visited.add(current);
                    walls=findWalls(walls, current);
                } 
            } else { //sein‰ on vaakasuora
                Pair uc=new Pair(nx.p1-1, nx.p2); //sein‰n yl‰puolella oleva solu
                Pair dc = new Pair(nx.p1+1, nx.p2); //sein‰n alapuolella oleva solu
                if (!visited.contains(uc)) { //teemme saman kuin pystysuorille seinille
                     maze[nx.p1][nx.p2]=2;
                     current=uc;
                     visited.add(current);
                     walls=findWalls(walls,current);
                } else if(!visited.contains(dc)) {
                    maze[nx.p1][nx.p2]=2;
                    current=dc;
                    visited.add(current);
                    walls=findWalls(walls,current);
                }
                
            }
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
        return l;
    }
    public void testFt() {
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
