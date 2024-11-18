
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class MyGraph {

    ArrayList<Vertices> listVertices = new ArrayList<>();
    ArrayList<Edge> listEdge = new ArrayList<>();

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
                System.out.print(currentVertex + " ");
                visited.add(currentVertex);
                queue.addAll(currentVertex.getList());
            }
        }
    }

    public void dfs(String start) {
        Set<Vertices> visited = new HashSet<>();
        Stack<Vertices> stack = new Stack<>();
        TreeSet<Vertices> verticesSorted = new TreeSet<>(Comparator.comparing(Vertices::getVertices)); // Sắp xếp từ A-Z
        verticesSorted.addAll(listVertices);

        for (Vertices vertex : verticesSorted) {
            if (!visited.contains(vertex)) {
                stack.push(vertex);
                while (!stack.isEmpty()) {
                    Vertices currentVertex = stack.pop();
                    if (!visited.contains(currentVertex)) {
                        System.out.print(currentVertex + " ");
                        visited.add(currentVertex);

                        for (Vertices neighbor : currentVertex.getList()) {
                            if (!visited.contains(neighbor)) {
                                stack.push(neighbor);
                            }
                        }
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

    public void addVertex(Vertices vertices) {
        listVertices.add(vertices);
    }

    public void addEgde(Vertices start, Vertices end, int weight) {
        Edge ed = new Edge(start, end, weight);
        listEdge.add(ed);
    }

    public void generate() {
        Vertices a = new Vertices("A");
        Vertices b = new Vertices("B");
        Vertices c = new Vertices("C");
        Vertices d = new Vertices("D");
        Vertices e = new Vertices("E");
        Vertices f = new Vertices("F");
        Vertices g = new Vertices("G");
        a.addEgde(b);
        a.addEgde(d);
        a.addEgde(c);
        b.addEgde(a);
        b.addEgde(d);
        b.addEgde(e);
        d.addEgde(a);
        d.addEgde(b);
        d.addEgde(c);
        d.addEgde(e);
        d.addEgde(f);
        d.addEgde(g);
        e.addEgde(b);
        e.addEgde(d);
        c.addEgde(a);
        c.addEgde(d);
        c.addEgde(g);
        c.addEgde(e);
        f.addEgde(d);
        f.addEgde(g);
        g.addEgde(d);
        g.addEgde(c);
        g.addEgde(f);
        this.addEgde(a, b, 4);
        this.addEgde(a, c, 2);
        this.addEgde(b, a, 6);
        this.addEgde(b, d, 2);
        this.addEgde(b, e, 3);
        this.addEgde(c, d, 4);
        this.addEgde(c, g, 2);
        this.addEgde(c, e, 7);
        this.addEgde(d, a, 3);
        this.addEgde(d, b, 1);
        this.addEgde(d, e, 1);
        this.addEgde(d, f, 2);
        this.addEgde(e, d, 4);
        this.addEgde(f, d, 3);
        this.addEgde(f, g, 1);
        this.addEgde(g, d, 3);

        this.addVertex(a);
        this.addVertex(b);
        this.addVertex(c);
        this.addVertex(d);
        this.addVertex(e);
        this.addVertex(f);
        this.addVertex(g);
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.generate();
        graph.bfs("A");
        System.out.println();
        graph.dfs("A");
    }
}
