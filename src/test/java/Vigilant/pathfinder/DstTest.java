/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vigilant.pathfinder;
import Vigilant.pathfinder.Datastructures.*;
import Vigilant.pathfinder.pathfinding.*;
/**
 *
 */
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//Random-luokan testaaminen ei onnistu unit-testeill�, mutta testasin sen app-luokassa seuraavasti:
/*
        Random r = new Random();
        int arr[]=new int[20000];
        for (int i=0;i<999999;i++) {
            int w = r.getRand(20000);
            arr[w]++;
        }
        for (int j=1900;j<2000;j++) {
            System.out.println(arr[j]);
        }
*/
//t�ss� siis alustetaan 20,000:n kokoinen taulukko ja annetaan sille 999,999 satunnaista lukua v�lilt� 0-19,999. kokeilin samaa my�s pienemmill� taulukoilla ja eri kohdista taulukkoa,
//ja tuloksena oli aina oikean n�k�isi� lukuja (esim. t�ss� tapauksessa oletuksena on, ett� jokaista lukua esiintyy noin 50 kertaa, mik� on totta). 999x999 labyrintti vaatii enint��n
//noin 13,500 alkion kokoisen taulukon, joten t�m�n random-funktion pit�isi varmasti toimia my�s v�h�n isommille taulukoille
public class DstTest {
    Dst dst;
    Dst dst2;
    Stack stack;
    int maze[][];
    int size;
   // Primlab prim;
    @Before 
    public void setUp() {
        dst=new Dst(2);
        dst2=new Dst(3);
        stack=new Stack(10);
        int maze[][]= new int[10][10];
        int size = 9;
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
        maze[1][0]=2;
        maze[2][1]=2;
        maze[2][3]=2;
        maze[3][0]=2;
        maze[3][4]=2;
        maze[3][8]=2;
        maze[4][7]=2;
        maze[5][0]=2;
        maze[5][6]=2;
        maze[5][8]=2;
        maze[6][1]=2;
        maze[6][3]=2;
        maze[6][5]=2;
        maze[7][6]=2;
        maze[7][8]=2;
        this.maze=maze;
        
    }
    @Test
    public void minSize() { //testaa, hyv�ksyyk� Dst koon oikein
        String tavoite = "Too small!!!";
        assertEquals(tavoite, dst.testMap());
        String tavoite2="t";
        assertEquals(tavoite2, dst2.testMap());
    }
    /* vanhentunut
    @Test
    public void mazeSetUp() { //t�m� tarkistaa sek� itse labyrintin alustamisen t�yteen nollia ett� l�ht�pisteen
        prim.createMaze();
        assertEquals(1, prim.maze[3][3]);
    }
    */
    @Test 
    public void listTest() { //testaa listaa
        List<Integer> l1=new List<Integer>(2);
        l1.add(2);
        l1.add(7);
        int g = l1.get(1);
        assertEquals(7, g); 
        l1.add(99);
        g=l1.get(2); //testaamme listan automaattista kasvamista taulukon koon ylittyess�
        assertEquals(99, g);
    }
    
    @Test 
    public void listRemoveTest() {
        List<Pair>lp = new List<Pair>(5);
        Pair pair=new Pair (5,10);
        Pair pair2 = new Pair(1,2);
        lp.add(pair);
        lp.add(pair2);
        lp.remove(0);
        assertEquals(2, lp.get(0).p2); //testaa remove-funktion toimintaa objektilla
    }

    @Test
    public void pairTest() {
        Pair pair=new Pair(3,5); //Pair tukee vain integerej�
        assertEquals(5, pair.p2);
        Pair pair2 = new Pair(3,6);
        pair2.p2--;
        boolean t = true;
        assertEquals(t, pair.equals(pair2));
    }
    @Test
    public void stackTest() {
        Stack stak = new Stack(5);
        stak.push(3);
        stak.push(2);
        stak.pop();
        assertEquals(3, stak.pop());
        stak.push(1);
        stak.push(99);
        assertEquals(99, stak.peek());
        assertEquals(2, stak.size());
    }
    @Test
    public void queueTest() {
        Queue q = new Queue(10);
        q.add(5);
        q.add(3);
        assertEquals(false, q.isEmpty());
        assertEquals(5, q.getNext());
        assertEquals(3, q.getNext());
        assertEquals(true, q.isEmpty());
        Queue<Pair> qp=new Queue(3);
        Pair p = new Pair(5, 77);
        qp.add(p);
        assertEquals(77, qp.getPair().p2);
    }
    @Test
    public void combinationTest() {//testaamme listaa objekteilla, stack ja pair eiv�t viel� tue objekteja
        List<Pair>lp = new List<Pair>(5);
        Pair pair=new Pair (5,10);
        Pair pair2 = new Pair(1,2);
        lp.add(pair);
        lp.add(pair2);
        assertEquals(10, lp.get(0).p2);
        Pair pair3= new Pair(5,10);
        assertEquals(true, lp.contains(pair3));
        List<Stack>ls = new List<Stack>(5);
        stack.push(1);
        Stack stak= new Stack(5);
        stak.push(1);
        ls.add(stack);
        ls.add(stak);
        assertEquals(1, ls.get(1).pop());
    }   
    @Test
    public void tstackTest() {
        Tstack tstack=new Tstack(5);
        Triple t1=new Triple(0,1,2);
        Triple t2=new Triple(4,5,7);
        Triple t3=new Triple (9,9,0);
        Triple t4=new Triple(3,5,4);
        tstack.push(t1);
        tstack.push(t2);
        tstack.push(t3);
        tstack.push(t4);
        assertEquals(0, tstack.pop().p3); //kaikki t�ss� annetut p3-arvot ovat uniikkeja, joten oikeellisuuden voi tarkistaa n�inkin helposti
        assertEquals(2, tstack.pop().p3);
        assertEquals(4, tstack.pop().p3);
        assertEquals(7, tstack.pop().p3);
        assertEquals(0, tstack.size());
    }
    
    @Test   
    public void dfsTest() { //teemme manuaalisesti labyrintin, mist� tied�mme kuinka monta liikett� DFS tarvitsee sen ratkaisemiseen
        DFS dfs = new DFS(maze); //labyrintti on siirretty setuppiin
        assertEquals(14, dfs.search()); //piirsin labyrintin k�sin ja tarkistin, kuinka monta siirtymist� DFS ja BFS tekisiv�t.
    }
    @Test
    public void astarTest() { //sama kuin yll�, paitsi A-star
        Astar astar= new Astar(maze);
        assertEquals(14, astar.search());
    }
    @Test
    public void bfsTest() {
        BFS bfs = new BFS(maze);
        assertEquals(15, bfs.search());        
    }
    

}
