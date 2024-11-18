/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_8_tren_lop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Asus
 */
public class MyGraph {

    Set<Vertex> vertices = new HashSet<>();
    Deque<String> path = new ArrayDeque<>();
    
    
    public MyGraph() {
    }
    
    public MyGraph(Set<Vertex> vertices) {
        this.vertices = vertices;
    }
 
    public ArrayList<String> getListVerticesLabel() {
        ArrayList<String> list = new ArrayList<>();
        this.vertices.stream().forEach(vertex -> list.add(vertex.label));
        return list;
    }
    
    public Set<Vertex> getVertices() {
        return vertices;
    }
    
    public Vertex getVertex(String label) {
        return vertices.stream().filter(vertex -> vertex.label.equals(label)).findFirst().get();
    }

    public void addV(String label) {
        Vertex newV = new Vertex(label);
        this.vertices.add(newV);
    }

    public void addE(String u, String v, int n) {
        Vertex src = this.getVertex(u);
        Vertex dest = this.getVertex(v);
        src.adjList.put(dest, n);
        dest.adjList.put(src, n);
    }

    public void addEdgesBiDirection(String srcLabel, String destLabel, int weight) {
        if (!this.getListVerticesLabel().contains(srcLabel)) 
            this.addV(srcLabel);
        
        if (!this.getListVerticesLabel().contains(destLabel))
            this.addV(destLabel);
        
        Vertex src = this.getVertex(srcLabel);
        Vertex dest = this.getVertex(destLabel);
        src.adjList.put(dest, weight);
        dest.adjList.put(src, weight);
    }
    
    public void removeEdge(String srcLabel, String destLabel) {
        Vertex src = this.getVertex(srcLabel);
        Vertex dest = this.getVertex(destLabel);
        src.adjList.remove(dest);
        dest.adjList.remove(src);
    }
    
    
    // hiện theo tree
    public void displayGraph() {
        for (Vertex vertice : vertices) {
            System.out.print(vertice.label + " ");
            vertice.adjList.entrySet().stream().forEach(vertex -> System.out.print("(" + vertex.getKey().label + ", " + vertex.getValue() + ") "));
            System.out.println("");
        }
    }
 
    
    
    public MyGraph primMST(MyGraph graph) {
        MyGraph mst = new MyGraph();
        Set<Vertex> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        
        //initialize with the first vertex
        Vertex startVertex = graph.vertices.iterator().next();
        visited.add(startVertex);
        startVertex.adjList.entrySet().stream().forEach(entry -> pq.add(new Edge(startVertex, entry.getKey(), entry.getValue())));
        
        //add all edges of the start vertex to the priority queue
        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            Vertex from = minEdge.from;
            Vertex to = minEdge.to;
            if (!visited.contains(to)) {
//                mst.displayGraph();
//                System.out.println("");
//                System.out.println("");
                mst.addEdgesBiDirection(from.label, to.label, minEdge.weight);
                // add all edges of the 'to' vertex to the priority queue
                to.adjList.entrySet().stream().forEach(entry -> pq.add(new Edge(to, entry.getKey(), entry.getValue())));
            }
            visited.add(to);
            //add the edge to the MST and mark the 'to' vertex as visited
        }
        return mst;
    }
    
public List<String> findEulerCircuit(MyGraph graph) {
        List<String> check = this.getEulerianPathStartingVertices(graph);
        if (check.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> circuit = new ArrayList<>();
        Vertex start = graph.getVertex(check.get(0));
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        
        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.peek();
//            graph.displayGraph();
//            System.out.println("");
//            System.out.println("");
            
            if (currentVertex.adjList.size() > 0) {
                Vertex nextVertex = currentVertex.adjList.keySet().iterator().next(); // trả đỉnh kề đầu tiên trong tập hợp
                //remove the edge between currentVertex and nextVertex
                graph.removeEdge(currentVertex.label, nextVertex.label);
                stack.push(nextVertex);
            } else {
                stack.pop();
                circuit.add(currentVertex.label);
            }
        }
        
        return circuit;
    }
    
    public List<String> getEulerianPathStartingVertices(MyGraph graph) {
        List<String> startingVertices = new ArrayList<>();
        List<String> startVerticePath = new ArrayList<>();
        
        //count the number of vertices with odd degrees
        int oddDegreeCount = 0;
        for (Vertex vertex : graph.vertices) {
            startVerticePath.add(vertex.label);
            if (vertex.adjList.size() % 2 != 0) {
                oddDegreeCount++;
                startVerticePath.add(vertex.label);
            }
        }
        
        //check if the graph has an Eulerian path
        if (oddDegreeCount == 0) {
            return startingVertices;
        } else if (oddDegreeCount == 2) {
            return startVerticePath;
        } else {
            return new ArrayList<>();
        }
    }
}
