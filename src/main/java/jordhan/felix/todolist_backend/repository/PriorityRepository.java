package jordhan.felix.todolist_backend.repository;

import jordhan.felix.todolist_backend.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
