
package workermanager;


public class History extends Worker{
    String status;
    String date;

    public History() {
    }

    public History(String status, String date) {
        this.status = status;
        this.date = date;
    }

    public History(String status, String date, String id, String name, String workLocation, int age, double salary) {
        super(id, name, workLocation, age, salary);
        this.status = status;
        this.date = date;
    }
    
    public String displayHis(){
        return String.format("%8s %10s %2d %7.2f %6s %10s\n",getId(),getName(),getAge(), getSalary(), status, date );
    }
    
    
    
    
}
