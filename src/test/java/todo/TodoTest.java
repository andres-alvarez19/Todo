package todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoTest {
    private User user;
    private Task task;

    @BeforeEach
    void setUp() {
        user = new User("Juan");
        task = new Task ("Limpiar", "Limpiar la casa");
        user.addTask(task);
    }

    @Test
    void createTask() {
       assertEquals(1, user.getTasks().size());
    }

    @Test
    void editTaskDescription() {
        user.editTaskDescription(task, "Limpiar la casa y el jardín");
        assertEquals("Limpiar la casa y el jardín", task.getDescription());
    }
    @Test
    void editTaskName() {
        user.editTaskName(task, "Lavar");
        assertEquals("Lavar", task.getName());
    }
    @Test
    void completeTask() {
        user.completeTask(task);
        assertEquals(true, task.isCompleted());
    }
    @Test
    void deleteTask() {
        user.deleteTask(task);
        assertEquals(0, user.getTasks().size());
    }
    @Test
    void deleteNonExistentTask() {
        Task task2 = new Task ("Limpiar", "Limpiar la casa");
        user.deleteTask(task2);
        assertEquals(1, user.getTasks().size());
    }
    @Test
    void editNonExistingTask() {
        Task task2 = new Task ("Limpiar", "Limpiar la casa");
        user.editTaskDescription(task2, "Limpiar la casa y el jardín");
        assertEquals("Limpiar la casa", task2.getDescription());
    }

}