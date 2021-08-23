package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(Long s) {
    }

    public ApiRequestException(String s) {
    }

    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Requested student does not exist"
    )
    public class StudentNotFoundException
            extends RuntimeException {

        public StudentNotFoundException(Throwable t) {
            super(t);
        }
    }
}