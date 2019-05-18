package mx.geckox.myfin.controllers.advices;

import mx.geckox.myfin.api.ErrorDto;
import mx.geckox.myfin.exceptions.ModelNotFoundException;
import mx.geckox.myfin.exceptions.MyFinException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyFinControllerAdvice {
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(MyFinException.class)
  public ErrorDto exception(Exception ex) {
    return new ErrorDto(500, ex.getMessage());
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ModelNotFoundException.class)
  public ErrorDto notFound(ModelNotFoundException ex) {
    return new ErrorDto(HttpStatus.NOT_FOUND.value(), ex.getMessage());
  }
}
