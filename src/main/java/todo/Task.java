package todo;

/**
 * Clase que representa una tarea
 * @Author: Andres Alvarez, Sebastian Vidal
 * @Version: 1.0
 * @Since: 19/06/2024
 */
public class Task {
    private User user;
    private String name;
    private String description;
    private boolean completed;

    public Task(User user, String name, String description) {
        this.user = user;
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public User getUser() {
        return user;
    }

    /**
     * Marca la tarea como completada
     */
    public void complete() {
        this.completed = true;
    }
}