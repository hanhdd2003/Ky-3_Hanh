/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package task;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hanh
 */
public class TaskManagerTest {

    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Task 1", "Description 1");
        taskManager.addTask(task);
        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testAddTaskExist() {
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = task1;
        taskManager.addTask(task1);
        assertTrue(taskManager.getTasks().contains(task1)); // Kiểm tra công việc thứ nhất đã được thêm vào
        taskManager.addTask(task2);
        // Đảm bảo rằng chỉ có một công việc trong danh sách
        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        Task task1 = new Task("Task 1", "Description 1");
        Task task2 = new Task("Task 2", "Description 2");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.removeTask(task1);
        List<Task> tasks = taskManager.getTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void testRemoveTaskNoExist() {
        Task task = new Task("Task 1", "Description 1");
        // Xóa công việc
        taskManager.removeTask(task);
        // Kiểm tra xem danh sách công việc vẫn là trống
        List<Task> tasks = taskManager.getTasks();
        assertEquals(0, tasks.size());
    }

}
