package jordhan.felix.todolist_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TodoListException extends RuntimeException {
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Ocorreu um erro com a solicitação.");
        return pb;
    }
}
