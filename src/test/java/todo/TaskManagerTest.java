package todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private TaskManager taskManager;
    private User user;
    private Task task;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        user = new User("Usuario");
        task = taskManager.createTask(user,"Titulo", "Descripcion");
    }
    @Test
    @DisplayName("Task can be added to a user")
    void addTask() {
        assertEquals(1, user.getTasksLen());
    }
    @Test
    @DisplayName("TaskManager can create a task")
    void createTask() {
        assertNotNull(task);
    }
    @Test
    @DisplayName("Task have a name")
    void taskName() {
        assertEquals("Titulo", task.getName());
    }
    @Test
    @DisplayName("Task have a description")
    void taskDescription() {
        assertEquals("Descripcion", task.getDescription());
    }
    @Test
    @DisplayName("Task is not completed by default")
    void taskIsNotCompleted() {
        assertFalse(task.isCompleted());
    }
    @Test
    @DisplayName("Task can be completed")
    void completeTask() {
        taskManager.completeTask(task);
        assertTrue(task.isCompleted());
    }
    @Test
    @DisplayName("Task can be deleted")
    void deleteTask() {
        taskManager.deleteTask(task);
        assertNull(taskManager.getTask(task));
    }
    @Test
    @DisplayName("Task can be edited")
    void editTask() {
        taskManager.editTask(task, "Nuevo Titulo", "Nueva Descripcion");
        assertEquals("Nuevo Titulo", task.getName());
        assertEquals("Nueva Descripcion", task.getDescription());
    }
    @Test
    @DisplayName("Task name can be edited")
    void editName() {
        taskManager.editName(task, "Lavar");
        assertEquals("Lavar", task.getName());
    }
    @Test
    @DisplayName("Task description can be edited")
    void editDescription() {
        taskManager.editDescription(task, "Limpiar la casa y el jardín");
        assertEquals("Limpiar la casa y el jardín", task.getDescription());
    }
    @Test
    void deleteNonExistentTask() {
        Task task2 = new Task ("Limpiar", "Limpiar la casa");
        assertThrows(IllegalArgumentException.class, () -> taskManager.deleteTask(task2));
    }
    @Test
    void editNonExistingTask() {
        Task task2 = new Task ("Limpiar", "Limpiar la casa");
        assertThrows(IllegalArgumentException.class,() -> taskManager.editDescription(task2, "Limpiar la casa y el jardín"));
    }
    @Test
    void testCreateTaskWithEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(user,"", "Description"));
    }
    @Test
    void testCreateTaskWithEmptyDescription() {
        assertNotNull(taskManager.createTask(user,"Title", ""));
    }
    @Test
    void testCreateTaskWithNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(user,null, "Description"));
    }
    @Test
    void testCreateTaskWithNullDescription() {
        assertNotNull(taskManager.createTask(user,"Title", null));
    }
    @Test
    void testEditTaskWithEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.editTask(task, "", "Description"));
    }
    @Test
    void testEditTaskWithNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.editTask(task, null, "Description"));
    }
    @Test
    void testEditTaskWithEmptyDescription() {
        assertNotNull(taskManager.editTask(task, "Title", null));
    }
    @Test
    void testCreateTaskWithNullUser() {
        assertThrows(IllegalArgumentException.class, () -> taskManager.createTask(null,"Title", "Description"));
    }
}