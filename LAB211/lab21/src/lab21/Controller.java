/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author admin
 */
public class Controller {

    private List<Student> listStudent = new ArrayList<>();

    public List<Student> getStudentById(String id) {
        List<Student> result = new ArrayList<>();
        for (Student student : listStudent) {
            if (id.equalsIgnoreCase(student.getId())) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getStudent() {
        return listStudent;
    }

    public boolean addStudent(String id, String name, int semester, String course) {
        List<Student> duplicate = getStudentById(id);
        if (duplicate.size() > 0) {
            if (!name.equalsIgnoreCase(duplicate.get(0).getStudentName())) {
                return false;
            }
            for (Student student : duplicate) {
                if (semester == student.getSemester() && course.equalsIgnoreCase(student.getCourseName())) {

                    return false;
                }
            }
        }
        listStudent.add(new Student(id, name, semester, course));
        return true;
    }

    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }

        }
        return result;
    }

    public void sortByName(List<Student> input) {
        Collections.sort(input, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
    }

    public boolean checkStudentExist(String id, String name, int semester, String courseName) {
        for (Student student : listStudent) {
            if (id.equals(student.getId())
                    && (semester == student.getSemester())
                    && name.equals(student.getStudentName())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

}
