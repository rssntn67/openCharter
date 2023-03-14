package OpenCharterDB.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NaveNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NaveNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String NaveNotFoundHandler(NaveNotFoundException ex) {
        return ex.getMessage();
    }
}