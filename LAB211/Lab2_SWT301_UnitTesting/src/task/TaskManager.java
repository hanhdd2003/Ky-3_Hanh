package task;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TaskManager {

    private static final Logger LOG = Logger.getLogger(TaskManager.class.getName());

    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (!tasks.contains(task)) {
            tasks.add(task);
        } else {
            LOG.info("Task already exist");
        }
    }

    public void removeTask(Task task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
        } else {
            LOG.info("Not exist task");
        }
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

   
    
}
