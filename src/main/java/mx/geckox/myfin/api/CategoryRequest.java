package mx.geckox.myfin.api;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import org.springframework.lang.Nullable;

@Data
public class CategoryRequest {

  @Nullable
  private Long parentCategoryId;

  @NotEmpty
  private String name;

  @Nullable
  private String icon;

  public CategoryRequest() {}

  public CategoryRequest(String name, String icon) {
    this.name = name;
    this.icon = icon;
  }

  public CategoryRequest(Long parentCategoryId, String name, String icon) {
    this.parentCategoryId = parentCategoryId;
    this.name = name;
    this.icon = icon;
  }
}
