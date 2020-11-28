/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Vigilant.pathfinder;
import Vigilant.pathfinder.Datastructures.Pair;
import Vigilant.pathfinder.Datastructures.List;
import Vigilant.pathfinder.Datastructures.Stack;
import Vigilant.pathfinder.pathfinding.DFS;
public class App {
    public String getGreeting() {
        return "Hello world!";
    }

    public static void main(String[] args) {
        
        Primlab prim = new Primlab(17);
        prim.createMaze(); //luo labyrintin
        //prim.testFt();
        int maze[][]=prim.getMaze(); //returnaa labyrintin matriisina
        DFS dfs = new DFS(maze);
        dfs.search(); //etsii polun
        dfs.testFt(); //tulostaa labyrintin, voisi hyvin k�ytt�� samaa funktiota primill�.
        
      
    }
}
