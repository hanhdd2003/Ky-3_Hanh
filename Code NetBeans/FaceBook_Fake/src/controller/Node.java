/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Asus
 */
public class Node<T> {

    Vertex<T> data;
    Node<T> next;

    public Node(Vertex<T> data) {
        this.data = data;
        this.next = null;
    }
}
