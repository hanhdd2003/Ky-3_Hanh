/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwriteobject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Hanh
 */
public class TestObject {

    private final ArrayList<Student> ls = new ArrayList<>();

    public void generate() {
        ls.add(new Student("H1", "Hanh", 8.9));
        ls.add(new Student("H2", "Thủy", 8));
        ls.add(new Student("H3", "Đức", 7.5));
        ls.add(new Student("H4", "Thắng", 7.3));
        ls.add(new Student("H5", "Chung", 8.8));
    }

    public void save() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter("student.txt"))) {
            for (Student l : ls) {
                w.write(l.toString());
                w.newLine();
            }
        } catch (Exception e) {
        }
    }

    public void readFile(ArrayList<Student> list) {

        try (BufferedReader r = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] str = line.split(", ");
                String id = str[0];
                String name = str[1];
                double mark = Double.parseDouble(str[2]);
                list.add(new Student(id, name, mark));
            }
        } catch (Exception e) {
        }
    }

    public void saveStream() {
        try (FileOutputStream os = new FileOutputStream("studentStream.txt");
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(ls); // Ghi danh sách ls vào file
        } catch (Exception e) {
        }
    }

    public ArrayList<Student> readStream() {
        ArrayList<Student> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("studentStream.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            list = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            
        }
        return list;
    }


    public static void main(String[] args) {
        TestObject t = new TestObject();
        t.generate();
        t.save();
        ArrayList<Student> list = new ArrayList<>();

        t.saveStream();
        //list = t.readStream();
        t.readFile(list);
//        list = t.readStream();
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

}
