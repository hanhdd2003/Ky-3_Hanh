/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hanh
 */
public class V {
    String vertices;
    Set<V> list = new HashSet<>();

    public V(String vertices) {
        this.vertices = vertices;
    }
    public void addEgde(V v){
        list.add(v);
    }

    public Set<V> getList(){
        return list;
    }
    public void display(){
        for(V v : list){
            System.out.print(v+" ");
        }
    }
    @Override
    public String toString() {
        return vertices ;
    }
    
}
