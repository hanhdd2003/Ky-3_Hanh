/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 *
 * @author Hanh
 */
public class Controller {

    private final ArrayList<Student> listStudent = new ArrayList<>();

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    //------------------ funtion 1-------------------------
    public boolean addStudent(String id, String name, int semester, String course) {
        Student s = new Student(id, name, semester, course);
        if (this.checkIDExist(id)) {
            if (this.checkIdAndName(id, name) && !this.checkEqualStudent(s)) {
                listStudent.add(s);
                return true;
            } else {
                return false;
            }
        } else {
            listStudent.add(s);
            return true;
        }
    }

    //------------------- funtion 2-----------------------
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : listStudent) {
            if (s.getStudentName().contains(name)) {
                result.add(s);
            }
        }
        this.sortByName(result);
        return result;
    }

    //------------------- funtion 3 (update) --------------
    public ArrayList<Student> findByID(String id) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean updateStudent(Student oldStudent, String newName, int newSemester, String newCourse) {
        //chỉ cập nhật tên
        if (oldStudent.getSemester() == newSemester && oldStudent.getCourseName().equalsIgnoreCase(newCourse)) {
            if (!oldStudent.getStudentName().equalsIgnoreCase(newName)) {
                for (Student student : listStudent) {
                    if (student.getId().equalsIgnoreCase(oldStudent.getId())) {
                        student.setStudentName(newName);
                    }
                }
                return true;
            }
        }
        // cập nhật cả tên cả kì học cả môn
        ArrayList<Student> result = this.findByID(oldStudent.getId());
        if (!checkSemesterAndCourse(result, newSemester, newCourse)) {
            if (!oldStudent.getStudentName().equalsIgnoreCase(newName)) {
                for (Student student : listStudent) {
                    if (student.getId().equalsIgnoreCase(oldStudent.getId())) {
                        student.setStudentName(newName);
                    }
                }
            }
            //oldStudent.setStudentName(newName);
            oldStudent.setCourseName(newCourse);
            oldStudent.setSemester(newSemester);
            return true;
        }
        return false;
    }
    //------------------- funtion 3 (Remove)---------------

    public boolean remove(Student s) {
        Logger logger = Logger.getLogger(Controller.class.getName());
        if (this.checkEqualStudent(s)) {
            listStudent.remove(s);
            logger.info("remove success");
            return true;
        }
        return false;
    }

    //------------------- funtion 4 -----------------------
    public ArrayList<Report> addReport() {
        ArrayList<Report> listReport = new ArrayList<>();
        String name;
        String course;
        Report r;
        for (Student st : listStudent) {
            name = st.getStudentName();
            course = st.getCourseName();
            r = this.getReport(listReport, name, course);
            if (r == null) {
                listReport.add(new Report(name, course, 1));
            } else {
                r.setTotal(r.getTotal() + 1);
            }
        }
        return listReport;
    }

    //==================================================
    public boolean checkEqualStudent(Student s) {
        for (Student a : listStudent) {
            if (a.getId().equalsIgnoreCase(s.getId())
                    && a.getStudentName().equalsIgnoreCase(s.getStudentName())
                    && a.getSemester() == s.getSemester()
                    && a.getCourseName().equalsIgnoreCase(s.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIDExist(String id) {
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIdAndName(String id, String name) {
        for (Student s : listStudent) {
            if (s.getId().equalsIgnoreCase(id) && s.getStudentName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private void sortByName(ArrayList<Student> ls) {
        Collections.sort(ls, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
    }

    private boolean checkSemesterAndCourse(ArrayList<Student> ls, int semester, String course) {
        for (Student student : ls) {
            if (student.getSemester() == semester && student.getCourseName().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    private Report getReport(ArrayList<Report> listReport, String studentName, String course) {
        if (!listReport.isEmpty()) {
            for (Report report : listReport) {
                if (report.getNameStudent().equalsIgnoreCase(studentName) && report.getCourseName().equalsIgnoreCase(course)) {
                    return report;
                }
            }
        }
        return null;
    }
}
