
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Read_Write {
    
    public void writer(int[] a){
        try (BufferedWriter w = new BufferedWriter(new FileWriter("fileInt.txt"))){
            
            for(int x : a){
                w.write(x+"");
                w.newLine();
            }
            w.close();
        } catch (Exception e) {
        }
    }
    public int[] reader(){
        ArrayList<Integer> s = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader("fileInt.txt"))){
            String line;
            while ((line = r.readLine()) != null) {                
               s.add(Integer.valueOf(line));
            }
            r.close();
        } catch (Exception e) {
        }
        int[] result = new int[s.size()];
        for (int i = 0; i < s.size(); i++) {
            result[i] = s.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Read_Write rw = new Read_Write();
        int[] s = {3,5,3,6,8,9,234,354,35,324,22};
        rw.writer(s);
        int[] c = rw.reader();
/*        for (int i = 0; i < c.length; i++) {
           System.out.println(c[i]);
        }*/
    }
}
