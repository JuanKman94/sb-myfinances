package mx.geckox.myfin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Object not found")  // 404
public class ModelNotFoundException extends MyFinException {
  protected static final String DEFAULT_MESSAGE = "Model not found";
  public ModelNotFoundException() { super(DEFAULT_MESSAGE); }
}