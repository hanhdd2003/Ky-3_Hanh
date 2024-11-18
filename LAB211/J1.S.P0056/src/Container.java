/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public class Container {

    private final Validate val = new Validate();
    private final Controller con = new Controller();

    public int menu() {
        System.out.println("===== Worker Management =====");
        System.out.println("1. Add Worker");
        System.out.println("2. Up Salary");
        System.out.println("3. Down Salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        return val.choice(1, 5);
    }

    public void addWorker() {
        String code = val.inID();
        String name = val.inName();
        int age = val.inAge();
        double Salary = val.inSalary();
        String workLocation = val.inWorkLocation();
        if (con.addWorker(code, name, age, Salary, workLocation)) {
            System.out.println("Add Worker successfully");
        } else {
            System.out.println("Add worker false");
        }
    }

    public void updateSalary(boolean a) {
        String code = val.inID();
        double salary = val.inSalary();
        Worker w = con.getLastUpdate(code);
        if (w == null) {
            System.out.println("Not exist worker have code " + code);
            return;
        }
        Worker temp = new Worker(w.getId(), w.getName(), w.getAge(), w.getSalary(), w.getWorkLocation());     
        if (a) {
            // up salary
            temp.setSalary(temp.getSalary() + salary);
            con.addHistory(temp, "Up");
            System.out.println("Up salary complete");
        } else {
            // down salary
            if (temp.getSalary() < salary) {
                temp.setSalary(0);
            } else {
                temp.setSalary(temp.getSalary() - salary);
            }
            con.addHistory(temp, "Down");
            System.out.println("Down salary complete");

        }
    }

    public void displaySalary() {
        Worker s;
        con.sortByID(con.getListHistorys());
        System.out.printf("%-10s%-20s%-15s%-15s%-15s%-15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
        for (History his : con.getListHistorys()) {
            s = his.getWorker();
            System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s\n", s.getId(),
                    s.getName(), s.getAge(), s.getSalary(), his.getStatus(), his.getDate());
        }
    }

    public void generate() {
        con.addWorker("HE3", "Hoàng Thủy", 20, 1500, "Hà Nội");
        con.addWorker("HE1", "Mạnh Hùng", 25, 1700, "Hòa Lạc");
        con.addWorker("HE2", "Công Thắng", 22, 1300, "Hưng Yên");
        con.addWorker("HE4", "Ngô Thương", 23, 1500, "Hòa Lạc");
        con.addWorker("HE5", "Việt Chung", 24, 1400, "Nam Định");
    }

    public static void main(String[] args) {
        Container man = new Container();
        man.displaySalary();
    }
}
