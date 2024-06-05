package jordhan.felix.todolist_backend.controller.Dto;

import jordhan.felix.todolist_backend.entity.Priority;

public record UpdateTaskDto (Priority.Enum priority, String name, String description, boolean complete) {
}

