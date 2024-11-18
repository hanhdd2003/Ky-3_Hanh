/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Manager {

    Validation v = new Validation();
    Controller c = new Controller();
    Scanner scanner = new Scanner(System.in);

    public void creatStudent() {
        int count = 0;
        boolean isContinue = true;
        while (isContinue) {
            String id = v.checkString("Enter Id: ");
            String name = v.checkString("Enter Name: ");
            int semester = v.checkInt("Enter Semester: ");
            String course = v.checkInputCourse("Enter course: ");
            if (c.addStudent(id, name, semester, course) == true) {
                System.out.println("Success");
                count++;
                if (count >= 2) {
                    System.out.println("Do you want continue?(Y/N)");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("N")) {
                        break;
                    } else {
                        continue;
                    }
                }
            } else {
                System.out.println("Enter again");
            }
        }

    }

    public void findAndSort() {
        String name = v.checkString("Enter name: ");
        c.findByName(name);
        if (c.findByName(name).isEmpty()) {
            System.out.println("No student");
        } else {
            c.sortByName(c.findByName(name));
            System.out.printf("%-15s%-15s%-15s\n", "StudentName", "Semester", "Course Name");
            for (Student student : c.findByName(name)) {
                student.print();
            }
        }

    }

    public void updateOrDelete() {
        String id = v.checkString("Enter id");
        List<Student> listStudentFindByID = c.getStudentById(id);
        if (listStudentFindByID.isEmpty()) {
            System.out.println("Not found student.");
        } else {
            Student student = getStudentFound(listStudentFindByID);
            System.out.println("Do you want update or delete");
            String choice = v.checkString("Enter choice: ");
            if (choice.equalsIgnoreCase("U")) {
                while (true) {
                    String name = v.checkString("Enter name:");;
                    int semester = v.checkInt("Enter semester:");
                    String course = v.checkInputCourse("Enter course: ");
                    if (!c.checkStudentExist(id, name, semester, course)) {
                        System.out.println("Duplicate");
                    } else {
                        if (!name.equalsIgnoreCase(student.getStudentName())) {
                            for (Student change_name : c.getStudent()) {
                                if (change_name.getId().equals(id)) {
                                    change_name.setStudentName(name);
                                }
                            }
                        }
                        student.setId(id);
                        student.setStudentName(name);
                        student.setSemester(semester);
                        student.setCourseName(course);
                        return;
                    }

                }

            } else {
                c.getStudent().remove(student);
            }
        }
    }

    public Student getStudentFound(List<Student> listStudentFindByID) {
        System.out.println("List student found: ");
        int count = 0;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByID) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        int choice = v.checkChoice("Enter choice:", 0, listStudentFindByID.size() - 1);
        return listStudentFindByID.get(choice);
    }
    public void report() {
        HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : c.getStudent()) {
            String key = student.getId() + "|" + student.getStudentName() + "|" + student.getCourseName();
            reports.put(key, reports.getOrDefault(key, 0) + 1);
        }

        for (String key : reports.keySet()) {
            String[] parts = key.split("\\|");
            String id = parts[0];
            String name = parts[1];
            String course = parts[2];
            int count = reports.get(key);

            System.out.println(name + " | " + course + " | " + count);
        }
    }

    public void generateStudent() {
        c.getStudent().add(new Student("s1", "long", 1, "Java"));
        c.getStudent().add(new Student("s1", "long", 2, ".NET"));
        c.getStudent().add(new Student("s1", "long", 3, "C/C++"));
        c.getStudent().add(new Student("s2", "van", 1, "Java"));
        c.getStudent().add(new Student("s2", "van", 2, "Java"));
        c.getStudent().add(new Student("s3", "toan", 3, "C/C++"));
        c.getStudent().add(new Student("s4", "nam", 1, "Java"));
        c.getStudent().add(new Student("s5", "ha", 2, ".NET"));
        c.getStudent().add(new Student("s5", "ha", 3, "Java"));
        c.getStudent().add(new Student("s6", "man", 1, "Java"));
        for (Student student : c.getStudent()) {
            System.out.println(student.getStudentName());
        }
    }
}
