/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi_7_tren_lop;

import java.util.HashMap;
import javax.print.attribute.HashAttributeSet;

/**
 *
 * @author Asus
 */
public class Vertex {
    String label;
    
    HashMap<Vertex, Integer> adjList = new HashMap<Vertex, Integer>();

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public HashMap<Vertex, Integer> getAdjList() {
        return adjList;
    }
    
    
}
