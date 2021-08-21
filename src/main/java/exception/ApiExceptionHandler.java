package exception;

import com.thanachai.API.Bill.Bill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
   // @RequestBody
    @ExceptionHandler(value = {ApiRequestException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
     String ApiRequestException (ApiRequestException ex){
        return ex.getMessage();
    }

    public ResponseEntity<Bill> handleApiRequestException(ApiRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity(apiException, badRequest);
    }
}
