package mx.geckox.myfin.services;

import mx.geckox.myfin.api.CategoryRequest;
import mx.geckox.myfin.entities.Category;
import mx.geckox.myfin.exceptions.ModelNotFoundException;
import mx.geckox.myfin.repositories.CategoriesRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
  @Autowired
  private CategoriesRepository categoriesRepository;

  private static final Logger log = LogManager.getLogger(CategoriesService.class);

  public Category find(Long id) throws ModelNotFoundException {
    return this.categoriesRepository
        .findById(id)
        .orElseThrow(ModelNotFoundException::new);
  }

  public Iterable<Category> all() {
    return categoriesRepository.findAll();
  }

  public Category create(CategoryRequest input) {
    log.info("creating category {}", input);
    Category category = new Category(
        input.getParentCategoryId(),
        input.getName(),
        input.getIcon());
    log.info("saving category {}", category);

    return this.categoriesRepository.save(category);
  }

  public Category update(Long id, CategoryRequest input) {
    Category category = this.categoriesRepository.findById(id).orElseThrow(ModelNotFoundException::new);

    category.setParentCategoryId(input.getParentCategoryId());
    category.setName(input.getName());
    category.setIcon(input.getIcon());

    return this.categoriesRepository.save(category);
  }

  public void delete(Long id) {
    Category category = this.categoriesRepository.findById(id).orElseThrow(ModelNotFoundException::new);
    this.categoriesRepository.delete(category);
  }
}
