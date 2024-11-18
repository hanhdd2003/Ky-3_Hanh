package workermanager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Manager {

    ArrayList<Worker> ws;
    ArrayList<History> hs;

    public Manager() {
        ws = new ArrayList<>();
        hs = new ArrayList<>();
    }

    private int choice() {
        int choice;
        System.out.println("1. add worker");
        System.out.println("2. up salary");
        System.out.println("3. down salary");
        System.out.println("4. display");
        System.out.println("5. exit");
        choice = Validation.inputInt(1, 5);
        return choice;
    }

    public void menu() {
        while (true) {
            switch (choice()) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    upSalary();
                    break;
                case 3:
                    downSalary();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private void addWorker() {
        Worker o = new Worker();
        System.out.println("id: ");
        String id = Validation.inputID();
        if (checkWorkerExist(id)) {
            System.out.println("Id already exist");
            return;
        }
        System.out.println("name: ");
        String name = Validation.inputString();
        System.out.println("Work location: ");
        String workLocation = Validation.inputString();
        System.out.println("Age: ");
        int age = Validation.inputInt(18, 50);
        System.out.println("Salary: ");
        double salary = Validation.inputDouble(0, Integer.MAX_VALUE);
        ws.add(new Worker(id, name, workLocation, age, salary));
        System.out.println("Successfully");
    }

    private void upSalary() {
        Worker o;
        String code;

        System.out.println("Enter code: ");
        code = Validation.inputID();
        o = findById(code);
        if (o == null) {
            System.out.println("Code not exist in database");
            return;
        }

        System.out.println("Enter Salary: ");
        double salary = Validation.inputDouble(o.getSalary(), Double.MAX_VALUE);
        o.setSalary(salary);
        LocalDate currentDate = java.time.LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd\\MM\\yyyy");
        String formattedDate = currentDate.format(formatter);
        hs.add(new History("UP", formattedDate, o.getId(), o.getName(), o.getWorkLocation(), o.getAge(), o.getSalary()));
        System.out.println("Successfully");
    }

    private void downSalary() {
        Worker o;
        String code;

        System.out.println("Enter code: ");
        code = Validation.inputID();
        o = findById(code);
        if (o == null) {
            System.out.println("Code not exist in database");
            return;
        }

        System.out.println("Enter Salary: ");
        double salary = Validation.inputDouble(0, o.getSalary());
        o.setSalary(salary);

        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd\\MM\\yyyy");
        String formattedDate = currentDate.format(formatter);
        hs.add(new History("Down", formattedDate, o.getId(), o.getName(), o.getWorkLocation(), o.getAge(), o.getSalary()));
        System.out.println("Successfully");
    }

    private void display() {
        if (hs.isEmpty()) {
            System.out.println("Nothing in history");
            return;
        }
        System.out.printf("%8s %10s %2d %7.2f %6s %10s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (History h : this.hs) {
            h.displayHis();
        }
    }

    private boolean checkWorkerExist(String id) {
        for (Worker w : this.ws) {
            if (w.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private Worker findById(String id) {
        for (Worker o : this.ws) {
            if (o.getId().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

   

}
