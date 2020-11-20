/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder.Datastructures;
import java.util.Random; //tilap�inen
/**
 *
 * @author panda
 */
//Teemme listan
//T�ss� kohtaa olen vaihtanut labyrintin rakennuksessa k�ytett�vi� tietorakenteita ainakin 3 kertaa
//Lista on ainakin aina hy�dyllinen
public class List<T> {
    private Object arr[];
    public int size=0;
    public List(int s) {
        arr=new Object[s];
        size=this.size;
    }
    public void add (T t) {
        // listaan lis��misen yhteydess� pit�� tarkistaa, ett� taulukossa riitt�� tilaa. t�m� tehd��n tuplaamalla se aina kun tila uhkaa ylitty�
        if (size>=arr.length) { //t�ss� olisi ehk� paras k�ytt�� javan omaa arraycopy-funktiota, jos t�m� hidastaa generointia liikaa          
            Object elements[]=new Object[size*2];
            for (int i=0;i<arr.length;i++) {
                elements[i]=arr[i];
            }
            elements[size++]=t;
            arr=new Object[size*2];
           for (int i=0;i<elements.length;i++) {
               arr[i]=elements[i];
            }
        } else {
            arr[size++]=t;
        }     
    }
    public T get(int n) {
        return (T) arr[n];
    }
    public void remove (int n) { //poistaa elementin listasta
        if (n<size) {
            size--;
            for (int i=n;i<size;i++) {
                arr[i]=arr[i+1];
            }
        }    
    }   
    public int getRand() {
        Random r = new Random();
        return r.nextInt(size-1);
    }
    public Pair getPair(int n) { //parien sis�ltymist� varten tehty funktio, ainoa tapa jolla sain toimimaan
        return (Pair) arr[n];
    }
    public boolean contains(Pair p) { //t�m� funktio on vain parille
        for (int i=0;i<size;i++) {
            Pair t = getPair(i);
            if (t.equals(p)) {
                return true;
            }
        }
        return false;
    }
    
}
