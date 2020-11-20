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
        //0 on sein‰, 1 on polkua, 2 on tilaa jota ei oikeasti ole olemassa (eli ei polkua)
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
                        maze[i][j]=2;
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
        /* ei toimi viel‰, j‰‰ looppiin
        while (visited.size<totalcells) {
            int next=walls.getRand(); //otamme satunnaisen solun merkityist‰
            Pair nx = walls.get(next);
            
            walls.remove(next);
            
        }
*/
        

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
