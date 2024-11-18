/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Hanh
 */
public class Save_Load_Book {
    private final ArrayList<Book> list = new ArrayList<>();
    
    public void genrate(){
        list.add(new Book("Book 1", "Hoàng Thủy", 2015, 120000));
        list.add(new Book("Book 2", "Viết Đức", 2018, 100000));
        list.add(new Book("Book 3", "Việt Chung", 2020, 125000));
        list.add(new Book("Book 4", "Công Thắng", 2023, 150000));
    }
    public void save(){
        try (FileOutputStream fis = new FileOutputStream("Book.txt");
              ObjectOutputStream oos = new ObjectOutputStream(fis)  ){
            oos.writeObject(list);
        } catch (Exception e) {
        }
    }
    
    public ArrayList<Book> load(){
        ArrayList<Book> b = new ArrayList<>();
        try (FileInputStream fio = new FileInputStream("Book.txt");
             ObjectInputStream ois = new ObjectInputStream(fio)   ){
            b = (ArrayList<Book>) ois.readObject();
        } catch (Exception e) {
        }  
        return b;
    }
    public static void main(String[] args) {
        Save_Load_Book s = new Save_Load_Book();
        s.genrate();
        s.save();
        ArrayList<Book> b = s.load();
        for (Book book : b) {
            System.out.println(book.toString());
        }
    }
}
