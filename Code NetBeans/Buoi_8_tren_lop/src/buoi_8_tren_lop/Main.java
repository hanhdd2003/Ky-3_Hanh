/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_8_tren_lop;

import java.util.List;

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
        graph.addEdgesBiDirection("A", "B", 3);
        graph.addEdgesBiDirection("A", "C", 4);
        graph.addEdgesBiDirection("B", "D", 3);
        graph.addEdgesBiDirection("B", "E", 2);
        graph.addEdgesBiDirection("C", "D", 2);
        graph.addEdgesBiDirection("C", "E", 2);
        graph.addEdgesBiDirection("D", "F", 4);
        graph.addEdgesBiDirection("G", "D", 1);
        graph.addEdgesBiDirection("F", "G", 2);
        
        MyGraph mst = graph.primMST(graph);
        mst.displayGraph();
        System.out.println("");
        System.out.println("");
        
        List<String> euler = graph.findEulerCircuit(graph);
        euler.stream().forEach(vertex -> System.out.print(vertex + " "));
//        List<Vertex> eu = graph.findEulerCircuit(graph);
//        eu.stream().forEach(vertex -> System.out.print(vertex.label + " "));
//        graph.removeEdge("A", "B");
//        System.out.println("");
//        System.out.println("");
//        graph.displayGraph();
    
    }
}
