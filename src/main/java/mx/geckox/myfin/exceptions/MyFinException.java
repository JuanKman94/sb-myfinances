package mx.geckox.myfin.exceptions;

public class MyFinException extends RuntimeException {
  protected static final String DEFAULT_MESSAGE = "There was an error with your request";

  public MyFinException() { super(DEFAULT_MESSAGE); }

  public MyFinException(String message) { super(message); }

  public MyFinException(Throwable throwable) { super(throwable); }

  public MyFinException(String message, Throwable throwable) { super(message, throwable); }
}
