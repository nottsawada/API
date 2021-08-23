package exception;

import com.thanachai.API.Bill.DataBill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    public ApiExceptionHandler() {

    }
//  @ExceptionHandler
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//    String ApiRequestException(ApiRequestException ex){
//        return ex.getMessage();
//    }
    @ResponseBody
    @ExceptionHandler(value = {ApiRequestException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
     String ApiRequestException (ApiRequestException ex){

        return ex.getMessage();
    }

    public ResponseEntity<DataBill> handleApiRequestException(ApiRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity(apiException, badRequest);
    }

       }
