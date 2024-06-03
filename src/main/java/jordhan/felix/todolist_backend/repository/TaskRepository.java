package jordhan.felix.todolist_backend.repository;

import jordhan.felix.todolist_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
