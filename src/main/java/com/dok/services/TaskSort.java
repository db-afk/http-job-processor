package com.dok.services;

import com.dok.models.Task;
import com.dok.models.Tasks;

import java.util.Map;
import java.util.stream.Collectors;


/**
 * Implementation of Topological sorting based on Depth-first algorithm
 *
 * @see <a href="https://en.wikipedia.org/wiki/Topological_sorting">Topological sorting</a>
 */
public final class TaskSort {

    private TaskSort() {
    }

    public static Tasks sort(Tasks tasks) {
        if (tasks == null || tasks.getTasks().isEmpty()) {
            return null;
        }

        // Empty list that will contain the sorted tasks
        Tasks orderedTasks = new Tasks();

        // Initially mark all task as not visited
        Map<String, Boolean> visited = tasks
                .getTasks()
                .stream()
                .collect(Collectors.toMap(Task::getName, task -> false));

        // Traverse all non-visited tasks and search for required tasks which should be executed beforehand.
        tasks.getTasks()
                .stream()
                .filter(task -> !visited.get(task.getName()))
                .forEach(task -> visitTask(tasks, task.getName(), visited, orderedTasks));

        return orderedTasks;
    }

    private static void visitTask(Tasks tasks, String name, Map<String, Boolean> visited, Tasks orderedTasks) {
        visited.replace(name, true);

        // recursively check for required task
        tasks.getTask(name)
                .getRequires()
                .stream()
                .filter(require -> !visited.get(require))
                .forEach(require -> visitTask(tasks, require, visited, orderedTasks));

        orderedTasks.addTask(tasks.getTask(name));
    }
}
