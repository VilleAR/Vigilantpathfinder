/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;
import Vigilant.pathfinder.Datastructures.*;
/**
 *
 * @author panda
 */
//Sidewinder-algoritmi
//ns. "basic" algoritmi, eritt‰in yksinkertainen ja helppo toteuttaa, sek‰ triviaali ratkaista (jos aloitat ylh‰‰lt‰, alas liikkuminen on aina oikein)
//ei sovellu vertailuun, teen t‰m‰n vain itsens‰ takia.
public class Sidewinder { 
    public int smaze[][];
    private int size;
    private boolean visited[][];
    
        public Sidewinder (int size) {
        this.size=size;
        int adjsize=size*2;
        int smaze[][]=new int[adjsize][adjsize];
        this.smaze=smaze;
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
                        smaze[i][j]=1;
                    }
                } else {
                    if (j%2!=0) {
                        smaze[i][j]=9;
                    }
                }
                if(smaze[i][j]==0) {
                    smaze[i][j]=2;
                }
                
            }
        }
        //ensimm‰inen rivi j‰‰ t‰ysin kuljettavaksi
        //alamme tekem‰‰n muita rivej‰
        Random r = new Random();
        int n = (smaze[0].length-1)/2; //seinien m‰‰r‰ solmurivill‰
        
        for (int i=2;i<smaze[0].length;i++) { //jokaisella solmurivill‰ otamme satunnaisen pisteen, johon laitamme sein‰n
            int t = 1; //t‰ll‰ muuttujalla "etenemme" rivill‰ ja lis‰‰mme seini‰ ja koloja kattoon
            while (t<n-1) {
                int v = n-t;
                int z=r.getRand(v)+1; //liikumme eteenp‰in rivill‰
                System.out.println(z);
                t=t+z;
                smaze[i][t*2]=0;
                
            }
            t=0;
            i++; //t‰ss‰ k‰ymme l‰pi vain joka toisen rivin
            
        }    
    }
    
    public void testFt() { // tulostaa labyrintin
        int n = size;
        for (int j=0; j<n;j++) {
            for (int i=0; i<n ;i++) {
                String s=Integer.toString(smaze[j][i]);
                System.out.printf(s+" ");
            }
            System.out.println("");
        }
    }
}
