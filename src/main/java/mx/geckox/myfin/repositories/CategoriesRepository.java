package mx.geckox.myfin.repositories;

import mx.geckox.myfin.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Category, Long> {
  Category findByName(String name);
}
