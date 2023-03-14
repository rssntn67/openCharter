package OpenCharterDB.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InfoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(InfoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String InfoNotFoundHandler(InfoNotFoundException ex) {
        return ex.getMessage();
    }
}