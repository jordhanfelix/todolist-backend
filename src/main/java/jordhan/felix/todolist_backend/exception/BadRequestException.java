package jordhan.felix.todolist_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class BadRequestException extends TodoListException {

    private String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pb.setTitle("Ocorreu um erro com a solicitação.");
        pb.setDetail(message);
        return pb;
    }

}
