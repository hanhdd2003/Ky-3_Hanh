/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hanh
 */
public class MyGraph {

private Map<Integer, List<Integer>> adjacencyList;

    public MyGraph() {
        adjacencyList = new HashMap<>();
    }
    // Thêm đỉnh vào đồ thị
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Thêm cạnh vào đồ thị
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // Đối với đồ thị vô hướng, hãy thêm cả cạnh ngược
        adjacencyList.get(destination).add(source);
    }

    // Lấy danh sách kề của một đỉnh
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    // Kiểm tra sự tồn tại của một đỉnh trong đồ thị
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Kiểm tra sự tồn tại của một cạnh trong đồ thị
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.get(source).contains(destination);
    }

    // Lấy số lượng đỉnh trong đồ thị
    public int getVertexCount() {
        return adjacencyList.size();
    }

    // Lấy số lượng cạnh trong đồ thị (đối với đồ thị vô hướng, cạnh được tính hai lần)
    public int getEdgeCount() {
        int count = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count / 2;
    }

    // In đồ thị
    public void printGraph() {
        for (int vertex : adjacencyList.keySet()) {
            System.out.print("Vertex " + vertex + " is connected to: ");
            List<Integer> neighbors = adjacencyList.get(vertex);
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

}
