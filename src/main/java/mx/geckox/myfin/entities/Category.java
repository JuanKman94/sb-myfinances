package mx.geckox.myfin.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;

  private Long parentCategoryId;

  private String name;

  private String icon;

  /**
   * Pattern uses {@link java.text.SimpleDateFormat}
   *
   * {@see https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html}
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
  @Column(insertable = false, updatable = false)
  private Timestamp createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
  private Timestamp updatedAt;

  public Category() {}

  public Category(String name, String icon) {
    this.name = name;
    this.icon = icon;
  }

  public Category(Long parentCategoryId, String name, String icon) {
    this.parentCategoryId = parentCategoryId;
    this.name = name;
    this.icon = icon;
  }
}
