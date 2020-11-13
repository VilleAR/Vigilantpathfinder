/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;
import java.util.Random;
/**
 *
 * @author panda
 */
//tämä tiedosto on enimmäkseen javan kertaamista ja kurssilla sallittujen tietorakenteiden kanssa leikkimistä varten
//lopulliset tiedostot tulevat olemaan paljon selkeämpiä
//teen myös ensimmäisen labyrintin tässä tiedostossa
public class Dst {
private int arr[];    
private int maze[][];
private int size;
    public Dst(int size) {
        int arr[]=new int[10];
        this.arr=arr;
        int maze[][]=new int[size][size];
        this.maze=maze;
        this.size=size;
        arr[0]=5;
        arr[1]=2;
        
    }
    public String testMap() {
        if (size<3) {          
            return("Too small!!!");         
        }
        int n=size; //helpottaa koodausta
        //tämän metodin tarkoituksena on tulostaa labyrinttinä toimiva matriisi, jossa 0 on polkua, 1 alku, 3 loppu ja 2 seinää.
        int arrs[][];
        arrs=new int [n][n]; //tätä käytettiin enimmäkseen javan matriisien käsittelyn harjoittelemiseen //1=polku, 0=seinä          
        for (int j=0; j<n; j++) {
            int tmp[]=new int[n];
            arrs[j]=tmp;
        }
        //labyrintti alkaa kohdasta 0,0 ja loppuu kohtaan n-1,n-1
        //teemme labyrintin seinät eri metodissa testauksen helpottamista varten
        walls();
        return("t"); //tällä metodilla on return-arvo vain testausta varten
        
    }
    public void walls() {
        Random r=new Random(); //laitamme joka riville satunnaisen määrän seiniä (eli numeroita 2)
        //jos labyrintistä tulee näin liian usein mahdoton, satunnaisten seinien määrää pitää säätää
        //seinien luominen tulee todennäköisesti muuttumaan useasti, tämä on vasta ensimmäinen versio
        //Huom: pienillä labyrinteillä testaaminen voi usein tuottaa mahdottomia labyrinttejä, tarkoitus on kuitenkin tehdä suuria
        //jos labyrintti on joskus mahdoton, se ei välttämättä haittaa
        //labyrintin generointia voi silti ehkä parantaa, jos se tuntuu kehnolta (tämä on ensimmäinen versio)
        
        
        //jos koko rivi tuli täyteen seinää, joku poistetaan
        int n = size;
        for (int i=0; i<n; i++) {
            int counter=0; //tämä laskee rivin seinät
            for (int x=0; x<n; x++) {
                int wall=r.nextInt(4); //20% mahdollisuus tulla seinä
                if (wall<1) {
                    maze[i][x]=2;
                    counter++;
                }
            }  
            if (counter==n && i!=0 && i!=n-1) {
                int rep=r.nextInt(n-1) + 1; // näin saamme arvon, joka ei ole ulkoseinässä (ei n-1 tai 0)
                maze[i][rep]=0;
            }
        }
        //nyt käymme labyrintin läpi pystysuoraan, ja poistamme seinää täynnä olevat rivit
        for (int i=0; i<n; i++) {
            int counter=0;
            for (int j=0;j<n;j++) {
                if (maze[j][i]==2) {
                    counter++;
                }
            }
            if (counter==n && i!=0 && i!=n-1) {
                int rep=r.nextInt(n-1)+1;
                maze[rep][i]=0;
            }
        }
        //teemme seinät ja alun ja lopun lopuksi, jotta ne ovat varmasti oikein
        for (int i = 1; i<n-1; i++) {
            maze[i+1][0]=2;
            maze[0][i+1]=2;
            maze[n-1][i-1]=2;
            maze[i-1][n-1]=2;
        }
        maze[0][1]=0;
        maze[1][0]=0;
        maze[n-1][n-2]=0;
        maze[n-2][n-1]=0;
        maze[0][0]=1;
        maze[n-1][n-1]=3;
        maze[1][1]=0;
        maze[n-2][n-2]=0;
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
    public String toString() {
        //for (int i=0;i<arr[].length; i++){
        //    System.out.println(arr[i]);
        //}
        int c = arr[0];
        System.out.println(c);
        arr[0]=7;
        int b=arr[0];
        System.out.println(b);
        String s=Integer.toString(b);
        return ("aaa "+b);
    }
}
