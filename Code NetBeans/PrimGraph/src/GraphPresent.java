/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Hanh
 */
public class GraphPresent {

    ArrayList<Vertices> listVertices = new ArrayList<>();

    // bfs , set: visited, queue: ...., kiểm tra visit, sout, add in vist
    // dfs, set: visited, stack,
    public GraphPresent() {
    }

    public void addVertices(String vertices) {
        listVertices.add(new Vertices(vertices));
    }

    public void addEgde(String v1, String v2) {
        Vertices v11 = this.getIndex(v1);
        Vertices v22 = this.getIndex(v2);
        v11.addEgde(v22);
        v22.addEgde(v11);
    }

    public void bfs(String start) {
        Set<Vertices> visited = new HashSet<>();
        Queue<Vertices> queue = new LinkedList<>();
        Vertices v = this.getIndex(start);

        if (v == null) {
            System.out.println("Không tìm thấy đỉnh bắt đầu.");
            return;
        }

        queue.add(v);

        while (!queue.isEmpty()) {
            Vertices currentVertex = queue.poll();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + ", ");
                visited.add(currentVertex);
                queue.addAll(currentVertex.getList());
            }
        }
    }

    public void dfs(String start) {
        Set<Vertices> visited = new HashSet<>();
        Stack<Vertices> stack = new Stack<>();
        Vertices v = this.getIndex(start);

        if (v == null) {
            System.out.println("Không tìm thấy đỉnh bắt đầu.");
            return;
        }

        stack.push(v);

        while (!stack.isEmpty()) {
            Vertices currentVertex = stack.pop();
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + ", ");
                visited.add(currentVertex);

                // Lấy danh sách các đỉnh kề chưa được thăm và đưa vào ngăn xếp
                for (Vertices neighbor : currentVertex.getList()) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public Vertices getIndex(String v) {
        for (Vertices vt : listVertices) {
            if (vt.vertices.equalsIgnoreCase(v)) {
                return vt;
            }
        }
        return null;
    }

    public void display() {
        for (Vertices v : listVertices) {
            System.out.print(v + "(");
            v.display();
            System.out.print(")");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphPresent grap = new GraphPresent();
        grap.addVertices("A");
        grap.addVertices("B");
        grap.addVertices("C");
        grap.addVertices("D");
        grap.addVertices("E");
        grap.addVertices("F");
        grap.addVertices("G");
        grap.addEgde("A", "B");
        grap.addEgde("A", "C");
        grap.addEgde("A", "G");
        grap.addEgde("A", "F");
        grap.addEgde("C", "B");
        grap.addEgde("C", "D");
        grap.addEgde("C", "F");
        grap.addEgde("C", "G");
        grap.addEgde("F", "D");
        grap.addEgde("E", "B");
        grap.addEgde("E", "D");
        grap.addEgde("D", "B");

        grap.display();
        grap.bfs("A");
        System.out.println();
        grap.dfs("A");
    }

}
