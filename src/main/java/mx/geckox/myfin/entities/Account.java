package mx.geckox.myfin.entities;

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
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double balance;

  private String color;

  @Column(insertable = false, updatable = false)
  private Timestamp createdAt;

  private Timestamp updatedAt;

  public Account() {}

  public Account(String name, Double balance, String color) {
    this.name = name;
    this.balance = balance;
    this.color = color;
  }
}
