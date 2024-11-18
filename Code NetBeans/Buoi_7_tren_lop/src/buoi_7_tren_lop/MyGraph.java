/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_7_tren_lop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Asus
 */
public class MyGraph {

    Set<Vertex> vertices = new HashSet<>();
    Deque<String> path = new ArrayDeque<>();
    int[][] dist;

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

    public void addEdgeDirected(String u, String v, int n) {
        Vertex src = this.getVertex(u);
        Vertex dest = this.getVertex(v);
        src.adjList.put(dest, n);
    }
    
    public void initalizeDistances() {
        int V = vertices.size();
        
        dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else 
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int i = 0;
        for (Vertex vertex : vertices) {
            for (Map.Entry<Vertex, Integer> entry : vertex.adjList.entrySet()) {
                int j = getIndex(entry.getKey());
                dist[i][j] = entry.getValue();
            }
            i++;
        }
    }
    
    private int getIndex(Vertex vertex) {
        int index = 0;
        for (Vertex vertice : vertices) {
            if (vertice == vertex) {
                return index;
            }
            index++;
        }
        return -1;
    }
    
    public void floydWarShall() {
        int V = vertices.size();
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
    
    public void printPath() {
        System.out.println("Short path: ");
        int V = vertices.size();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print(getVertexLabel(i) + " to " + getVertexLabel(j) + ": ∞, ");
                else 
                    System.out.print(getVertexLabel(i) + " to " + getVertexLabel(j) + ": " + dist[i][j] + ", ");
            }
            System.out.println("");
        }
    }
    
    private String getVertexLabel(int index) {
        int i = 0;
        for (Vertex vertex : vertices) {
            if (i == index) {
                return vertex.label;
            }
            i++;
        }
        return null;
    }
    // hiện theo tree
    public void displayGraph() {
        for (Vertex vertice : vertices) {
            System.out.print(vertice.label + " ");
            vertice.adjList.entrySet().stream().forEach(vertex -> System.out.print("(" + vertex.getKey().label + ", " + vertex.getValue() + ") "));
            System.out.println("");
        }
    }

    public void dijkstra(String startLabel, String targetLabel) {
        MyQueue queue = new MyQueue();
        List<Vertex> visited = new ArrayList<>();
        HashMap<Vertex, Integer> distanceToVertex = new HashMap<>();
        HashMap<Vertex, Vertex> previous = new HashMap<>();

        this.vertices.stream().forEach(entry -> distanceToVertex.put(entry, Integer.MAX_VALUE));
        Vertex startVertex = this.getVertex(startLabel);
        distanceToVertex.put(startVertex, 0);
        System.out.println("");
        previous.put(startVertex, startVertex);
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {
            //
            Vertex currentVertex = queue.dequeue().data;

            if (!visited.contains(currentVertex)) {
                distanceToVertex.entrySet().stream().forEach(entry -> System.out.print("(" + entry.getKey().label + ", " + entry.getValue() + ") "));
                System.out.println("");
                //duyệt qua các đỉnh kề
                currentVertex.adjList.entrySet().stream().forEach(entry -> {
                    //lưu trữ khoảng cách tạm thời từ đỉnh xuất phát đến đỉnh kề hiện tại 
                    int currentDistance = distanceToVertex.get(currentVertex) + entry.getValue();
                    queue.enqueue(entry.getKey());
                    if (currentDistance < distanceToVertex.get(entry.getKey())) {
                        distanceToVertex.put(entry.getKey(), currentDistance);
                        previous.put(entry.getKey(), currentVertex);
                    }
                });
            }
            visited.add(currentVertex);
        }
        this.path = this.getPath(previous, startLabel, targetLabel);
        System.out.println("");
    }

    public void printShortestPath(String start, String end, HashMap<Vertex, Vertex> previous) {
        Vertex endVertex = this.getVertex(end);
        Vertex currentVertex = endVertex;
        List<Vertex> path = new ArrayList<>();

        while (!currentVertex.label.equals(start)) {
            path.add(currentVertex);
            currentVertex = previous.get(currentVertex);
            if (currentVertex == null) {
                System.out.println("No path found from " + start + " to " + end + ".");
                return;
            }
        }
        path.add(this.getVertex(start));
        Collections.reverse(path);

        System.out.print("Shortest path from " + start + " to " + end + ": ");
        for (Vertex vertex : path) {
            System.out.print(vertex.label + " -> ");
        }
        System.out.println("End");
    }

    private Deque<String> getPath(HashMap<Vertex, Vertex> previous, String startLabel, String targetLabel) {
        Vertex current = previous.entrySet().stream().filter(vertexVertexEntry -> vertexVertexEntry.getKey().label.equals(targetLabel)).findFirst().get().getKey();
        Deque<String> path = new ArrayDeque<>();
        while (!current.label.equals(startLabel)) {
            path.addFirst(current.label);
            current.label = previous.entrySet().stream().filter(entry -> entry.getKey().label.equals(current.label)).findFirst().get().getValue().label;
        }
        System.out.print(startLabel);
        path.stream().forEach(s -> System.out.print("->" + s));
        return path;
    }

}
