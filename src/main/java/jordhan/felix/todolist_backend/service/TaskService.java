package jordhan.felix.todolist_backend.service;

import jakarta.transaction.Transactional;
import jordhan.felix.todolist_backend.controller.Dto.InputTaskDto;
import jordhan.felix.todolist_backend.controller.Dto.OutputTaskDto;
import jordhan.felix.todolist_backend.controller.Dto.UpdateTaskDto;
import jordhan.felix.todolist_backend.entity.Task;
import jordhan.felix.todolist_backend.entity.User;
import jordhan.felix.todolist_backend.exception.BadRequestException;
import jordhan.felix.todolist_backend.repository.TaskRepository;
import jordhan.felix.todolist_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public List<OutputTaskDto> list(){

        Sort sort = Sort.by(Sort.Direction.DESC, "priority")
                .and(Sort.by(Sort.Direction.ASC, "id"));

        List<OutputTaskDto> tasks  = new ArrayList<>();
        taskRepository.findAll(sort).forEach(task -> tasks.add(task.toDto()));
        return tasks;
    }

    public List<OutputTaskDto> create(InputTaskDto request) {
        taskRepository.save(request.toTask());
        return list();
    }

    @Transactional
    public List<OutputTaskDto> assignUser(Long idTask, Long idUser) {
        User user = userRepository.findById(idUser).orElseThrow(() -> {
            throw new BadRequestException("Usuário %d não existe!".formatted(idUser));
        });

        Task existingTask = taskRepository.findById(idTask).orElseThrow(() ->{
             throw  new BadRequestException("Tarefa %d não existe!".formatted(idTask));
        });

        existingTask.setUser(user);
        taskRepository.save(existingTask);

        return list();
    }

    public List<OutputTaskDto> update(Long id, UpdateTaskDto todo) {
        taskRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            existingTodo.setName(todo.name());
            existingTodo.setDescription(todo.description());
            existingTodo.setPriority(todo.priority().get());
            existingTodo.setComplete(todo.complete());
            taskRepository.save(existingTodo);
        }, () -> {
            throw new BadRequestException("Tarefa %d não existe! ".formatted(id));
        });

        return list();
    }

    public List<OutputTaskDto> delete(Long id) {
        taskRepository.findById(id).ifPresentOrElse((existingTodo) -> taskRepository.delete(existingTodo), () -> {
            throw new BadRequestException("Tarefa %d não existe! ".formatted(id));
        });
        return list();
    }

    public List<OutputTaskDto> hasComplete(Long id, boolean value) {
        taskRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            existingTodo.setComplete(value);
            taskRepository.save(existingTodo);
        }, () -> {
            throw new BadRequestException("Tarefa %d não existe! ".formatted(id));
        });
        return list();
    }

}
