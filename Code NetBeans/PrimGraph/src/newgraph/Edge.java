package newgraph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Edge {
    private Vertices begin;
    private Vertices end;
    private int weight;

    public Edge(Vertices begin, Vertices end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }
    
}
