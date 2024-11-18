package newpackage;

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
public class ManageStudent {

    private final Validate val = new Validate();
    private final Controller con = new Controller();

    public ManageStudent() {
    }

    public int menu() {
        System.out.println("========= WELCOME TO STUDENT MANAGEMENT ========");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        return val.choice(1, 5);
    }

    public void create() {
        String id;
        String name;
        int semester;
        String course;
        while (true) {
            id = val.inID();
            name = val.inName();
            semester = val.inSemester();
            course = val.inCourse();
            if (con.addStudent(id, name, semester, course)) {
                System.out.println("Add student complete");
                if (con.getListStudent().size() >= 10) {
                    if (!val.checkYN()) {
                        break;
                    }
                }
            } else {
                System.out.println("Add student failed");
                break;
            }
        }
    }

    public void findByName() {
        String name = val.inNameToFind();
        ArrayList<Student> result = con.findByName(name);
        if (!result.isEmpty()) {
            this.displayList(result);
        } else {
            System.out.println("No have any Student " + name);
        }
    }

    public void upOrDel() {
        ArrayList<Student> listByID;
        Student old;
        String newName;
        String newCourse;
        int newSemester;
        String id = val.inID();
        if (!con.checkIDExist(id)) {
            System.out.println("No student have id: " + id);
            return;
        } else {
            listByID = con.findByID(id);
            old = this.findToUpdate(listByID);
            if (val.checkUD()) {
                //update
                newName = val.inName();
                newSemester = val.inSemester();
                newCourse = val.inCourse();
                if (con.updateStudent(old, newName, newSemester, newCourse)) {
                    System.out.println("Update complete");
                } else {
                    System.out.println("Update false");
                }

            } else {
                //delete
                if (con.remove(old)) {
                    System.out.println("Remove student complete");
                } else {
                    System.out.println("Remove student failed");
                }
            }
        }
    }

    public Student findToUpdate(ArrayList<Student> listByID) {
        int count = 1;
        System.out.format("   %-10s %-20s %-15s %-15s\n", "ID", "Name", "Semester", "Course Name");
        for (Student s : listByID) {
            System.out.print(count + ". ");
            s.display();
            count++;
        }
        int choice = val.choice(1, listByID.size());
        return listByID.get(choice - 1);
    }

    public void report() {

        ArrayList<Report> result = con.addReport();
        if (!result.isEmpty()) {
            for (Report r : result) {
                System.out.println(r.getNameStudent() + " | " + r.getCourseName() + " | " + r.getTotal());
            }
        } else {
            System.out.println("No have report");
        }

    }

    public void displayList(ArrayList<Student> ls) {
        System.out.format("%-10s %-20s %-15s %-15s\n", "ID", "Name", "Semester", "Course Name");
        ls.forEach((s) -> {
            s.display();
        });
    }

    public void generateStudent() {
        con.addStudent("s1", "long", 1, "Java");
        con.addStudent("s1", "long", 2, ".NET");
        con.addStudent("s1", "long", 3, "C/C++");
        con.addStudent("s2", "van", 1, "Java");
        con.addStudent("s2", "van", 2, "Java");
        con.addStudent("s3", "toan", 3, "C/C++");
        con.addStudent("s4", "nam", 1, "Java");
        con.addStudent("s5", "ha", 2, ".NET");
        con.addStudent("s5", "ha", 3, "Java");
        con.addStudent("s6", "man", 1, "Java");
        con.addStudent("s1", "long", 3, "Java");
//        for (Student student : con.getListStudent()) {
//            System.out.println(student.getStudentName());
//        }
    }

}
