/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_7_tren_lop;

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();

        graph.addV("A");
        graph.addV("B");
        graph.addV("C");
        graph.addV("D");
        graph.addV("E");
        graph.addV("F");

        graph.addE("A", "B", 7);
        graph.addE("A", "C", 9);
        graph.addE("A", "E", 14);
        graph.addE("B", "C", 10);
        graph.addE("B", "D", 15);
        graph.addE("C", "D", 6);
        graph.addE("C", "E", 2);
        graph.addE("D", "F", 6);
        graph.addE("E", "F", 11);

        //graph.displayGraph();
        System.out.println("");
        graph.dijkstra("A", "F");

        System.out.println("");
        System.out.println("");
        
        /*MyGraph graph1 = new MyGraph();
        graph1.addV("A");
        graph1.addV("B");
        graph1.addV("C");
        graph1.addV("D");
        graph1.addV("E");
        graph1.addV("F");
        graph1.addV("G");

        graph1.addEdgeDirected("A", "B", 4);
        graph1.addEdgeDirected("A", "C", 2);
        graph1.addEdgeDirected("B", "D", 2);
        graph1.addEdgeDirected("B", "E", 3);
        graph1.addEdgeDirected("C", "D", 4);
        graph1.addEdgeDirected("C", "E", 7);
        graph1.addEdgeDirected("C", "G", 2);
        graph1.addEdgeDirected("D", "A", 3);
        graph1.addEdgeDirected("D", "B", 1);
        graph1.addEdgeDirected("D", "E", 1);
        graph1.addEdgeDirected("D", "F", 2);
        graph1.addEdgeDirected("E", "D", 4);
        graph1.addEdgeDirected("F", "D", 3);
        graph1.addEdgeDirected("F", "G", 1);
        graph1.addEdgeDirected("G", "D", 3);

        graph1.initalizeDistances();
        graph1.floydWarShall();
        graph1.printPath();*/
    }
}
