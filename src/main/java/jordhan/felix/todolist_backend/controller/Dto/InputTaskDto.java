package jordhan.felix.todolist_backend.controller.Dto;

import jordhan.felix.todolist_backend.entity.Priority;
import jordhan.felix.todolist_backend.entity.Task;

public record InputTaskDto(Priority.Enum priority, String name, String description) {

    public Task toTask(){
        return  new Task(priority.get(), name, description);
    }
}
