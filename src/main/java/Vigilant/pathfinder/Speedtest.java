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
 * @author panda
 */
//nopeusvertailuja testaava luokka
public class Speedtest {
    
    public Speedtest() {
        
    }
    
    public void test(int size, int count) { //size on labyrintin koko, count on testien m‰‰r‰
        double gentime=0;
        double bfstime=0;
        double bfsmoves=0;
        double dfstime=0;
        double dfsmoves=0;
        double astartime=0;
        double astarmoves=0;
        for (int i=0;i<count;i++) {
            Primlab prim = new Primlab(size);
            long t = System.currentTimeMillis();
            prim.createMaze(); //luo labyrintin
            long t1=System.currentTimeMillis();
            gentime=gentime+(t1-t);
            //prim.testFt();
            int maze[][]=prim.getMaze();
            long t2=System.currentTimeMillis();
            BFS bfs = new BFS(maze);
            int q = bfs.search();
            bfsmoves=bfsmoves+q;
            long t3=System.currentTimeMillis();
            bfstime=bfstime+(t3-t2);
            DFS dfs = new DFS(maze);
            q=dfs.search();
            dfsmoves=dfsmoves+q;
            long t4=System.currentTimeMillis();
            dfstime=dfstime+(t4-t3);
            Astar astar= new Astar(maze);
            q=astar.search();
            astarmoves=astarmoves+q;
            long t5=System.currentTimeMillis();
            astartime=astartime+(t5-t4);
        }
        System.out.println("Labyrintin generoimiseen meni keskimaarin "+(gentime/count)+"ms.");
        System.out.println("BFS:lla kesti keskimaarin "+(bfstime/count)+"ms");
        System.out.println("BFS:lla meni keskimaarin "+(bfsmoves/count)+" siirtymista");
        System.out.println("DFS:lla kesti keskimaarin "+(dfstime/count)+"ms");
        System.out.println("DFS:lla meni keskimaarin "+(dfsmoves/count)+" siirtymista");
        System.out.println("Astarilla kesti keskimaarin "+(astartime/count)+"ms");
        System.out.println("Astarilla meni keskimaarin "+(astarmoves/count)+" sirtymista");
    }
    public void sideWinderTest(int size, int count) {
        double gentime=0;
        double bfstime=0;
        double bfsmoves=0;
        double dfstime=0;
        double dfsmoves=0;
        double astartime=0;
        double astarmoves=0;
        for (int i=0;i<count;i++) {
            Sidewinder side = new Sidewinder(size);
            long t = System.currentTimeMillis();
            side.createMaze(); //luo labyrintin
            long t1=System.currentTimeMillis();
            gentime=gentime+(t1-t);
            //prim.testFt();
            int maze[][]=side.getMaze();
            long t2=System.currentTimeMillis();
            /*BFS bfs = new BFS(maze);
            int q = bfs.search();
            bfsmoves=bfsmoves+q;
            long t3=System.currentTimeMillis();
            bfstime=bfstime+(t3-t2);
*/
            DFS dfs = new DFS(maze);
            long q=dfs.search();
            dfsmoves=dfsmoves+q;
            long t3=System.currentTimeMillis();
            dfstime=dfstime+(t3-t2);
            Astar astar= new Astar(maze);
            q=astar.search();
            astarmoves=astarmoves+q;
            long t4=System.currentTimeMillis();
            astartime=astartime+(t4-t3);
        }
        System.out.println("Labyrintin generoimiseen meni keskimaarin "+(gentime/count)+"ms.");
      //  System.out.println("BFS:lla kesti keskimaarin "+(bfstime/count)+"ms");
       // System.out.println("BFS:lla meni keskimaarin "+(bfsmoves/count)+" siirtymista");
        System.out.println("DFS:lla kesti keskimaarin "+(dfstime/count)+"ms");
        System.out.println("DFS:lla meni keskimaarin "+(dfsmoves/count)+" siirtymista");
        System.out.println("Astarilla kesti keskimaarin "+(astartime/count)+"ms");
        System.out.println("Astarilla meni keskimaarin "+(astarmoves/count)+" sirtymista");
    }
}
