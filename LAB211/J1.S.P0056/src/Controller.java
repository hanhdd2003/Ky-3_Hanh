
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hanh
 */
public class Controller {

    private final ArrayList<History> listHistorys = new ArrayList<>();

    public ArrayList<History> getListHistorys() {
        return listHistorys;
    }

    public boolean addWorker(String code, String name, int age, double salary, String workLocation) {
        if (this.getworkerByID(code) == null) {
            Worker w = new Worker(code, name, age, salary, workLocation);
            //listWorker.add(w);
            listHistorys.add(new History(w, "Up", this.getDate()));
            return true;
        }
        return false;
    }

    public void sortByID(ArrayList<History> his) {
        Comparator<History> c = new Comparator<History>() {
            @Override
            public int compare(History o1, History o2) {
                return o1.getWorker().getId().compareTo(o2.getWorker().getId());
            }
        };
        Collections.sort(his, c);
    }

    public void addHistory(Worker w, String status) {
        listHistorys.add(new History(w, status, this.getDate()));
    }

    public String getDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return now.format(formatter);
    }

    public Worker getworkerByID(String id) {
        for (History w : listHistorys) {
            if (w.getWorker().getId().equalsIgnoreCase(id)) {
                return w.getWorker();
            }
        }
        return null;
    }

    public Worker getLastUpdate(String id) {
        ArrayList<Worker> result = new ArrayList<>();
        for (History his : listHistorys) {
            if (his.getWorker().getId().equalsIgnoreCase(id)) {
                result.add(his.getWorker());
            }
        }
        if (!result.isEmpty()) {
            return result.get(result.size() - 1);
        }
        return null;
    }
}
