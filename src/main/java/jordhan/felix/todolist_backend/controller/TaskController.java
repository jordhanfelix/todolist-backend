package jordhan.felix.todolist_backend.controller;

import jordhan.felix.todolist_backend.controller.Dto.InputTaskDto;
import jordhan.felix.todolist_backend.controller.Dto.OutputTaskDto;
import jordhan.felix.todolist_backend.controller.Dto.UpdateTaskDto;
import jordhan.felix.todolist_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    ResponseEntity<List<OutputTaskDto>>  create(@RequestBody InputTaskDto task) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.create(task));
    }

    @GetMapping
    List<OutputTaskDto> list() {
        return taskService.list();
    }

    @PutMapping("{id}")
    ResponseEntity<List<OutputTaskDto>> update(@PathVariable Long id, @RequestBody UpdateTaskDto task) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(taskService.update(id ,task));
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }

    @PatchMapping("{idTask}/assign-user/{idUser}")
    ResponseEntity<List<OutputTaskDto>>  find(@PathVariable Long idTask, @PathVariable Long idUser) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(taskService.assignUser(idTask, idUser));
    }

    @PatchMapping("{id}/complete")
    ResponseEntity<List<OutputTaskDto>>  completeTask(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(taskService.hasComplete(id, true));
    }

    @PatchMapping("{id}/unfinished")
    ResponseEntity<List<OutputTaskDto>>  unfinishedTask(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(taskService.hasComplete(id, false));
    }

}
