package jordhan.felix.todolist_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NotFoundExeption extends TodoListException {

    private Long id;

    public NotFoundExeption(Long id) {
        this.id = id;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        pb.setTitle("Registro não encontrado.");
        pb.setDetail("Não foi encontrado nenhum registro com o id: " + id + ".");

        return pb;
    }
}
