package todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que guarda y administra las tareas
 * @Author: Andres Alvarez, Sebastian Vidal
 * @Version: 1.0
 * @Since: 19/06/2024
 */

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }
    /**
     * Crea una tarea
     * @param user Usuario que crea la tarea
     * @param titulo Titulo de la tarea
     * @param descripcion Descripcion de una tarea
     * @return Task Tarea creada
     * @throws IllegalArgumentException Si el titulo o usuario es null o esta vacio
     */
    public Task createTask(User user, String titulo, String descripcion) {
        Task task = new Task(user, titulo, descripcion);
        addTask(task);
        return task;
    }

    /**
     * Agrega una tarea a la lista de tareas
     * @param task Tarea a agregar a la lista de tareas
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

/**
 * Marca una tarea como completada
     * @param task Tarea a completar
     */
    public void completeTask(Task task) {
    }

    /**
     * Elimina una tarea de la lista
     * @param task Tarea a eliminar
     */
    public void deleteTask(Task task) {
    }

    /**
     * Obtiene una tarea de la lista
     * @param task Tarea a obtener de la lista
     * @return Task Tarea obtenida
     * @throws Exception Si la tarea no existe
     */
    public Task getTask(Task task) {
        return null;
    }

    /**
     * Edita una tarea
     * @param task Tarea a editar
     * @param titulo Titulo de la tarea
     * @param descripcion Descripcion de la tarea
     * @throws IllegalArgumentException Si la tarea no existe, o el titulo es null o esta vacio
     */
    public void editTask(Task task, String titulo, String descripcion) {
    }

    /**
     * Edita el nombre de una tarea
     * @param task Tarea a editar
     * @param nombre Nombre de la tarea
     * @throws IllegalArgumentException Si el nombre es null o esta vacio
     */
    public void editName(Task task, String nombre) {
    }

    /**
     * Edita la descripcion de una tarea
     * @param task Tarea a editar
     * @param descripcion Descripcion de la tarea
     */
    public void editDescription(Task task, String descripcion) {
    }

    /**
     * Obtiene las tareas de un usuario
     * @param user Usuario a obtener las tareas
     * @return lista de tareas del usuario
     */
    public List<Task> getUserTask(User user) {
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getUser().id().compareId(user.id())) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }
}
