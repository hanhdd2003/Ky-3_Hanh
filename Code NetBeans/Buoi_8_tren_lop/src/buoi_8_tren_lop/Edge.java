/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_8_tren_lop;

/**
 *
 * @author Asus
 */
public class Edge {
    public Vertex from;
    public Vertex to;
    public int weight;

    public Edge(Vertex from, Vertex to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    
}
