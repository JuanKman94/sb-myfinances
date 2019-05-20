package mx.geckox.myfin.api;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import org.springframework.lang.Nullable;

@Data
public class AccountDto {
  @NotEmpty
  private String name;

  @Min(0)
  @NotNull
  private Double balance;

  @Nullable
  private String color;

  public AccountDto() {}

  public AccountDto(String name, Double balance, String color) {
    this.name = name;
    this.balance = balance;
    this.color = color;
  }
}
