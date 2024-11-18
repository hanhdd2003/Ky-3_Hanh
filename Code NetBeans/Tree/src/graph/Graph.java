/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author Hanh
 */
import java.util.*;

class Graph {

    private int V; // Số đỉnh
    private LinkedList<Integer> adjList[]; // Danh sách kề

    public Graph(int vertices) {
        V = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjList[i] = new LinkedList();
        }
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int v, int w) {
        adjList[v].add(w); // Thêm w vào danh sách kề của v
    }

    // In đồ thị
    public void printGraph() {
        for (int i = 0; i < V; ++i) {
            System.out.print("Đỉnh " + i + " liên kết với: ");
            for (Integer node : adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
