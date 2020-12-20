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
                if(smaze[i][j]==0&&i%2==0) {
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
            while (t<n) {
                int v = n-t;
                int o=t;
                int z=r.getRand(v)+1; //liikumme eteenp‰in rivill‰
                
                t=t+z;
                if (t*2+1>smaze[0].length) {
                    smaze[i][smaze[0].length-2]=0;
                } else {
                    smaze[i][t*2+1]=0;
                }
                
                v=t-o; //poistamme katon
                z=r.getRand(v); //otamme satunnaisen katon ylemp‰n‰ m‰‰ritellylt‰ v‰lilt‰mme ja avaamme sen
                int tz=o+z;
                smaze[i-1][tz*2]=2;
                
            }
            t=1; //vainoluuloinen reset, t‰ysin turha
            i++; //t‰ss‰ k‰ymme l‰pi vain joka toisen rivin
            
        }    
        for (int i=0;i<smaze[0].length;i++) {
            if (i%2!=0) {
                smaze[smaze[0].length-2][i]=2;
            }
        }
    }
    public int[][]getMaze() {
        return smaze;
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
