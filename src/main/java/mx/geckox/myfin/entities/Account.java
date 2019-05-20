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
@Table()
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double balance;

  private String color;

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

  public Account() {}

  public Account(String name, Double balance, String color) {
    this.name = name;
    this.balance = balance;
    this.color = color;
  }
}
