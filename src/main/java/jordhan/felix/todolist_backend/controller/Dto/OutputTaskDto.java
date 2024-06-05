package jordhan.felix.todolist_backend.controller.Dto;

public record OutputTaskDto (Long id, String user, String priority, String name, String description, boolean complete){
}
