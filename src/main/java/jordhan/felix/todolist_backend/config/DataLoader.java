package jordhan.felix.todolist_backend.config;


import jordhan.felix.todolist_backend.entity.Priority;
import jordhan.felix.todolist_backend.repository.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    public DataLoader(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Priority.Enum.values())
                .forEach(priority -> priorityRepository.save(priority.get()));
    }
}
