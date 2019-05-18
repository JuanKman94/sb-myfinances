package mx.geckox.myfin.api;

import lombok.Data;

@Data
public class ErrorDto {
  private Integer code;
  private String message;

  public ErrorDto(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
