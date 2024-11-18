package newgraph;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hanh
 */
public class Vertices {
    String vertices;
    Set<Vertices> list = new HashSet<>();

    public Vertices(String vertices) {
        this.vertices = vertices;
    }
    public void addEgde(Vertices v){
        list.add(v);
    }

    public Set<Vertices> getList(){
        return list;
    }
    public void display(){
        for(Vertices v : list){
            System.out.print(v+" ");
        }
    }
    @Override
    public String toString() {
        return vertices ;
    }
    
}
