package jordhan.felix.todolist_backend.repository;

import jordhan.felix.todolist_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
