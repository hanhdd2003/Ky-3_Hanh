/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_6_tren_lop;

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
        graph.addV("G");

        graph.addE("A", "B");
        graph.addE("A", "C");
//        graph.addE("B", "A");
        graph.addE("B", "D");
//        graph.addE("B", "E");
//        graph.addE("C", "D");
//        graph.addE("C", "G");
//        graph.addE("C", "E");
//        graph.addE("D", "A");
//        graph.addE("D", "B");
        graph.addE("D", "E");
        graph.addE("D", "F");
//        graph.addE("E", "D");
//        graph.addE("F", "D");
        graph.addE("F", "G");
//        graph.addE("G", "D");

        
        graph.BFS("A");
        System.out.println("");
        graph.DFS("A");
        
//        Vertex vertexA = new Vertex("A");
//        Vertex vertexB = new Vertex("B");
//        Vertex vertexC = new Vertex("C");
//
//        // Add neighbors to vertices
//        vertexA.addNeighbor(vertexB);
//        vertexA.addNeighbor(vertexC);
//        vertexB.addNeighbor(vertexA);
//        vertexC.addNeighbor(vertexA);
//
//        // Display adjacency list
//        vertexA.displayADJ();
    }
}
